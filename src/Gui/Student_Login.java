package Gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Student_Login {
    JFrame student_login;
    JTextField username;
    JPasswordField password;
    JButton sign_in;
    JButton sign_up;
    JButton back;
    public Student_Login(JFrame frame)
    {
        frame.setVisible(false);
        student_login(frame);

    }
    public Student_Login(){}
    public void student_login(JFrame frame)
    {
        back = new JButton("Back");
        back.setBounds(1200,0,200,54);
        ImageIcon ba = new ImageIcon("Images/back.jpg");
        back.setIcon(ba);


        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(true);
                student_login.setVisible(false);
            }
        });


        student_login = new JFrame();
        student_login.setTitle("Student Login");
        student_login.setExtendedState(student_login.MAXIMIZED_BOTH);

        username = new JTextField();
        username.setBackground(Color.yellow);
        username.setBounds(650,400,150,40);

        password = new JPasswordField();
        password.setBackground(Color.yellow);
        password.setBounds(650,450,150,40);

        sign_in = new JButton("Sign in");
        sign_in.setBounds(400,520,300,100);
        ImageIcon in = new ImageIcon("Images/Inkedenter3_LI.jpg");
        sign_in.setIcon(in);


        sign_up = new JButton("Sign up");
        sign_up.setBounds(730,520,240,120);
        ImageIcon up = new ImageIcon("Images/join.png");
        sign_up.setIcon(up);


        sign_up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               SignUp_Student s = new SignUp_Student(student_login);
            }
        });
        sign_in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Sign_In_Student s = new Sign_In_Student(student_login,username.getText(),password.getText());
            }
        });



        JLabel label1 = new JLabel();
        label1.setBounds(10,0,1380,720);
        ImageIcon pen = new ImageIcon("Images/pen.jpg");
        label1.setIcon(pen);


        label1.add(back);
        label1.add(sign_up);
        label1.add(sign_in);
        label1.add(username);
        label1.add(password);
        student_login.add(label1);
        student_login.setLayout(null);
        student_login.setVisible(true);

    }
}
