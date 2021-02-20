package Gui;

import Code.Start_page_code;

import javax.swing.*;
import java.awt.*;

public class Start_Page {
    JButton student,teacher;

    public void start_page()
    {


        JFrame startpage = new JFrame();
        startpage.setExtendedState(startpage.MAXIMIZED_BOTH);
        startpage.setTitle("Start");

        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBounds(500,100,477,150);
        ImageIcon wel = new ImageIcon("Images/welcome.jpg");
        label.setIcon(wel);

        student= new JButton();
        teacher = new JButton();

        student.setBounds(1000,500,238,119);
        teacher.setBounds(200,500,238,119);

        ImageIcon stu = new ImageIcon("Images/students.jpg");
        student.setIcon(stu);

        ImageIcon tea = new ImageIcon("Images/teacher.jpg");
        teacher.setIcon(tea);


        JLabel label1 = new JLabel();
        label1.setBounds(0,0,1500,1000);
        ImageIcon imageIcon = new ImageIcon("Images/Start.jpg");
        label1.setIcon(imageIcon);


        label1.add(label);
        label1.add(student);
        label1.add(teacher);
        startpage.add(label1);
        startpage.setLayout(null);
        startpage.setVisible(true);
        Start_page_code s= new Start_page_code();
        s.student(student,startpage);
        s.teacher(teacher,startpage);

    }
}
