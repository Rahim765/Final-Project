package Code;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Explain_Azmon implements Serializable{
    String[] soal;
    ArrayList<String> name;
    LocalDate localDate;
    Date start;
    Date over;


    public Explain_Azmon(String[] soal, ArrayList<String> name, LocalDate localDate,Date start , Date over)
    {
        this.soal = soal;
        this.name = name;
        this.localDate = localDate;
        this.start = start;
        this.over = over;
        writeExplainAzmon();
    }
    public void writeExplainAzmon()
    {

        try {
            FileOutputStream  fileOutputStream = new FileOutputStream("Files/Exam.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(Explain_Azmon.this);
            outputStream.close();

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
