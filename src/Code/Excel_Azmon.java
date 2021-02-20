package Code;

import Gui.Tarahi_Azmon;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.*;
import java.util.ArrayList;

public class Excel_Azmon {
    double sum = 0;
    int x=0;
    double t=0;
    ArrayList<String> arrayList = new ArrayList<>();

    public Object[][] excel_azmon(String creator) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Files/ListAzmonHa.txt"));
            int z = 10;
            DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

            while (true) {

                String line = bufferedReader.readLine();

                if (line == null) {
                    break;
                }

                FileInputStream fileOutputStream = new FileInputStream("Exams/" + line + ".txt");
                ObjectInputStream objectOutputStream = new ObjectInputStream(fileOutputStream);
                Tarahi_Azmon tarahiAzmon = (Tarahi_Azmon) objectOutputStream.readObject();

                if (creator.equals(tarahiAzmon.creator)) {

                    for (int i = 0; i < tarahiAzmon.attends.size(); i++) {
                        File file = new File(line + "/" + tarahiAzmon.attends.get(i) + ".txt");
                        try {
                            FileInputStream fileOutputStream2 = new FileInputStream(file);
                            ObjectInputStream objectOutputStream2 = new ObjectInputStream(fileOutputStream2);
                            Tarahi_Azmon tarahi_azmon2 = (Tarahi_Azmon) objectOutputStream2.readObject();


                            sum += Integer.parseInt(tarahi_azmon2.nomrehjam.getText());


                        } catch (FileNotFoundException fileNotFoundException) {
                            fileNotFoundException.printStackTrace();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        }


                        t++;
                    }
                    arrayList.add(tarahiAzmon.nameazmon.getText());
                    arrayList.add(String.valueOf(sum/t));
                    sum=0;
                    t=0;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(arrayList.size());
        Object[][] objects = new Object[arrayList.size() / 2][2];
        System.out.println(objects.length);
        for (int i = 0; i < arrayList.size(); i+= 2) {
            objects[x][0] = arrayList.get(i);
            objects[x][1] = arrayList.get(i+1);
            x++;

        }
        return objects;
    }
}