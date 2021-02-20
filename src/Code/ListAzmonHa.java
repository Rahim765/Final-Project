package Code;

import sun.rmi.transport.ObjectTable;

import java.io.*;
import java.util.ArrayList;

public class ListAzmonHa{

    public ListAzmonHa(String name)
    {
        try {
            setAzmons(name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void setAzmons(String name) throws IOException, ClassNotFoundException {
        PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Files/ListAzmonHa.txt",true)));
        printWriter.println(name);
        printWriter.flush();
    }

}
