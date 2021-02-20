package Code;

import javax.swing.*;
import java.io.*;

public class SignUp_Student {
    PrintWriter printWriter = null;
    BufferedReader bufferedReader = null;
    boolean repeat = false;

    public SignUp_Student(JTextField name, JTextField lastname, JTextField Id, JTextField username, JTextField Password,
                          JLabel warning, JFrame frame, JFrame singup) {

        try {
            printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Files/Form_SabtName.txt", true)));
            sabt_name(name, lastname, Id, username, Password, warning, frame, singup);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sabt_name(JTextField name, JTextField lastname, JTextField Id, JTextField username,
                          JTextField Password, JLabel warning, JFrame frame, JFrame signup) {
        try {
            bufferedReader = new BufferedReader(new FileReader("Files/Form_SabtName.txt"));

            while (true) {
                String line = bufferedReader.readLine();

                if (line == null) {
                    break;
                }

                String[] s = line.split(" ");
                if (username.getText().equals(s[3])) {
                    repeat = true;
                    break;
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (repeat == false) {
            printWriter.println(name.getText() + " " + lastname.getText() + " " + Id.getText() + " " + username.getText()
                    + " " + Password.getText());
            printWriter.flush();

            frame.setVisible(true);
            signup.setVisible(false);

        } else if (repeat == true) {

            warning.setText("This UserName has given before!");

        }


    }

}
