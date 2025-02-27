package Code;
// Java implementation of the approach
import java.util.*;
import java.lang.Math;

public class RandomNumber {


        // Function to return the next random number
        static int getNum(ArrayList<Integer> v)
        {
            // Size of the vector
            int n = v.size();

            // Make sure the number is within
            // the index range
            int index = (int)(Math.random() * n);

            // Get random number from the vector
            int num = v.get(index);

            // Remove the number from the vector
            v.set(index, v.get(n - 1));
            v.remove(n - 1);

            // Return the removed number
            return num;
        }

        // Function to generate n
        // non-repeating random numbers
        public static int[] generateRandom(int n)
        {
            int[] array = new int[n];
            int x=0;
            ArrayList<Integer> v = new ArrayList<>(n);

            // Fill the vector with the values
            // 1, 2, 3, ..., n
            for (int i = 0; i < n; i++)
                v.add(i + 1);

            // While vector has elements
            // get a random number from the vector and print it
            while (v.size() > 0)
            {
                array[x]=getNum(v);
                x++;
            }
            return array;
        }


    }


