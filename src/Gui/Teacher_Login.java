package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teacher_Login {
    JFrame teacher_login;
    JTextField username;
    JPasswordField password;
    JButton sign_in;
    JButton sign_up;
    JButton back;
    public Teacher_Login(JFrame frame)
    {
        frame.setVisible(false);
        teacher_login(frame);
    }
    public Teacher_Login(){}
    public void teacher_login(JFrame frame)
    {
        back = new JButton("Back");
        back.setBounds(1170,15,200,54);
        ImageIcon ba = new ImageIcon("Images/back.jpg");
        back.setIcon(ba);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setVisible(true);
                teacher_login.setVisible(false);
            }
        });
        teacher_login = new JFrame();
        teacher_login.setTitle("Student Login");
        teacher_login.setExtendedState(teacher_login.MAXIMIZED_BOTH);

        JLabel label = new JLabel("Teacher");
        label.setOpaque(true);
        label.setBounds(510,100,450,114);
        ImageIcon la = new ImageIcon("Images/teachername.jpg");
        label.setIcon(la);


        username = new JTextField();
        username.setBackground(Color.yellow);
        username.setBounds(650,400,150,40);

        password = new JPasswordField();
        password.setBackground(Color.yellow);
        password.setBounds(650,450,150,40);

        sign_in = new JButton("Sign in");
        sign_in.setBounds(430,520,250,80);
        ImageIcon in = new ImageIcon("Images/signin.png");
        sign_in.setIcon(in);

        sign_up = new JButton("Sign up");
        sign_up.setBounds(730,520,260,80);
        ImageIcon up = new ImageIcon("Images/signup.jpg");
        sign_up.setIcon(up);

        sign_up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                SignUp_Teacher s = new SignUp_Teacher(teacher_login);
            }
        });

        sign_in.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Sign_In_Teacher s = new Sign_In_Teacher(teacher_login,username.getText(),password.getText());
            }
        });

        JLabel label1 = new JLabel();
        label1.setBounds(5,0,1400,700);
        ImageIcon imageIcon = new ImageIcon("Images/book.jpg");
        label1.setIcon(imageIcon);




        label1.add(back);
        label1.add(sign_up);
        label1.add(sign_in);
        label1.add(username);
        label1.add(password);
        label1.add(label);
        teacher_login.add(label1);
        teacher_login.setLayout(null);
        teacher_login.setVisible(true);

    }
}
