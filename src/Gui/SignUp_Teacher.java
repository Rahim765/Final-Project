package Gui;

import Code.Sign_up_Teacher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp_Teacher extends Sign_up{
    public SignUp_Teacher(JFrame frame) {
        super(frame);
        compelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Sign_up_Teacher s = new Sign_up_Teacher(name,lastname,UserName,password,warning,frame,signup);
            }
        });

    }
}
