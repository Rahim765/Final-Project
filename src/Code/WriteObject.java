package Code;

import Gui.Tarahi_Azmon;

import java.io.*;

public class WriteObject {
    public void writeobject(String path,Tarahi_Azmon tarahi_azmon)
    {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(tarahi_azmon);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NotSerializableException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
