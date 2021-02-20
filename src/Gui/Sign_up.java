package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sign_up {
    JFrame signup;
    JTextField name;
    JTextField lastname;
    JTextField UserName;
    JTextField password;
    JButton compelete;
    JLabel warning;
    JLabel label;
    JButton back2 = new JButton();
    public Sign_up(JFrame frame)
    {
        frame.setVisible(false);
        sign_up(frame);
    }
    public void sign_up(JFrame frame)
    {
        signup = new JFrame();
        signup.setTitle("Sign up Student");
        signup.setExtendedState(signup.MAXIMIZED_BOTH);

        name = new JTextField("name");
        name.setBounds(350,100,150,40);
        name.setBackground(Color.yellow);

        lastname = new JTextField("lastname");
        lastname.setBounds(350,180,150,40);
        lastname.setBackground(Color.yellow);

        warning = new JLabel();
        warning.setOpaque(true);
        warning.setBounds(1000,350,250,40);
        warning.setBackground(Color.red);

        UserName = new JTextField("User name");
        UserName.setBounds(350,360,150,40);
        UserName.setBackground(Color.yellow);

        password = new JTextField("passwoird");
        password.setBounds(350,440,150,40);
        password.setBackground(Color.yellow);

        compelete = new JButton("Complete");
        compelete.setBackground(Color.cyan);
        compelete.setBounds(1000,440,100,40);

        back2.setBounds(0,0,200,54);
        ImageIcon ba = new ImageIcon("Images/back.jpg");
        back2.setIcon(ba);
        back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                signup.setVisible(false);
            }
        });

        label = new JLabel();
        label.setBounds(0,0,1400,750);
        ImageIcon imageIcon = new ImageIcon("Images/up.jpg");
        label.setIcon(imageIcon);


        label.add(back2);
        label.add(warning);
        label.add(compelete);
        label.add(name);
        label.add(lastname);
        label.add(UserName);
        label.add(password);
        signup.add(label);

        signup.setLayout(null);
        signup.setVisible(true);

    }
}
