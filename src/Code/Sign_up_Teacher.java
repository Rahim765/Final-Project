package Code;

import javax.swing.*;
import java.io.*;

public class Sign_up_Teacher {
    PrintWriter printWriter = null;
    BufferedReader bufferedReader=null;
    boolean repeat=false;
    public Sign_up_Teacher (JTextField name, JTextField lastname, JTextField username, JTextField Password,
                            JLabel warning, JFrame frame, JFrame singup)
    {

        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Files/Teacher_List.txt",true)));
            sabt_name(name,lastname,username,Password,warning,frame,singup);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sabt_name(JTextField name,JTextField lastname,JTextField username,
                          JTextField Password,JLabel warning,JFrame frame,JFrame signup)
    {
        try {
            bufferedReader = new BufferedReader(new FileReader("Files/Teacher_List.txt"));

            while (true)
            {
                String line = bufferedReader.readLine();

                if (line==null) {
                    break;
                }

                String[] s = line.split(" ");
                if (username.getText().equals(s[2]))
                {
                    repeat =true;
                    break;
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (repeat==false) {
            printWriter.println(name.getText() + " " + lastname.getText() + " " + username.getText()
                    + " " + Password.getText());
            printWriter.flush();

            frame.setVisible(true);
            signup.setVisible(false);

        }
        else if (repeat ==true)
        {

            warning.setText("This UserName has given before!");

        }



    }

}
