package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp_Student extends Sign_up{
    JTextField ID;

    public SignUp_Student(JFrame frame)
    {
        super(frame);
        ID = new JTextField("ID");
        ID.setBounds(350,260,150,40);
        ID.setBackground(Color.yellow);
        label.add(ID);
        compelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Code.SignUp_Student s = new Code.SignUp_Student(name,lastname,ID,UserName,password,warning,frame,signup);
            }
        });
    }

}
