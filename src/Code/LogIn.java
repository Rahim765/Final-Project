package Code;

import java.io.*;

public class LogIn implements Serializable {


    public boolean check_sign_in(String username,String password,String filename,int x, int y)
    {
        try {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            while (true)
            {
                String line = bufferedReader.readLine();

                if (line==null) {
                    break;
                }

                String[] s = line.split(" ");
                if (username.equals(s[x])&&password.equals(s[y]))
                {
                    return true;
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean check_sign_in(String username,String filename,int x)
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

            while (true)
            {
                String line = bufferedReader.readLine();

                if (line==null) {
                    break;
                }

                String[] s = line.split(" ");
                if (username.equals(s[x]))
                {
                    return true;
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
