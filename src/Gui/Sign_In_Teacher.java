package Gui;

import Code.Excel_Azmon;
import Code.LogIn;
import Gui.Nomarat.Excel_1Azmon;
import Gui.Nomarat.Excel_Azmon_be_Azmon;
import Gui.Nomarat.Namodar;
import Gui.Nomarat.Namodar_Students;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sign_In_Teacher {
    String creator;
    JButton back;
    JFrame signin;
    public Sign_In_Teacher(JFrame frame, String username, String password)
    {

        back=  new JButton();
        ImageIcon ba = new ImageIcon("Images/back.jpg");
        back.setBounds(1150,0,200,54);
        back.setIcon(ba);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                signin.setVisible(false);
            }
        });


        this.creator = username;
        LogIn l = new LogIn();
        if (l.check_sign_in(username,password,"Files/Teacher_List.txt",2,3))
        {
            sign_in();
            frame.setVisible(false);

        }

    }

    public void sign_in()
    {
        signin = new JFrame();
        signin.setTitle("Sign in");
        signin.setExtendedState(signin.MAXIMIZED_BOTH);

        JCheckBox All = new JCheckBox("All",true);
        All.setBounds(200,100,100,40);
        All.setBackground(Color.yellow);


        JTextField tedad = new JTextField();
        tedad.setBounds(200,170,100,40);
        tedad.setBackground(Color.yellow);

        JCheckBox Separate = new JCheckBox("Separate",false);
        Separate.setBounds(200,250,100,40);
        Separate.setBackground(Color.yellow);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(Separate);
        buttonGroup.add(All);

        JButton tashih = new JButton("Correct");
        tashih.setBounds(700,100,240,198);
        ImageIcon co = new ImageIcon("Images/correct.png");
        tashih.setIcon(co);

        tashih.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Correcting correcting = new Correcting(signin,creator);
            }
        });




        JButton Azmon = new JButton("Azmon");
        Azmon.setBounds(300,100,195,189);
        ImageIcon azmon = new ImageIcon("Images/exam2.jpg");
        Azmon.setIcon(azmon);

        Azmon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                    Tarahi_Azmon t = new Tarahi_Azmon(signin,Integer.parseInt(tedad.getText())+1,Separate
                    ,creator);

            }
        });

        JLabel jLabel = new JLabel();
        jLabel.setBounds(250,350,282,235);
        ImageIcon imageIcon = new ImageIcon("Images/namodar.jpg");
        jLabel.setIcon(imageIcon);


        JButton namodar_azmon_be_azmon = new JButton("Namodar Azmon be Azmon");
        namodar_azmon_be_azmon.setBounds(0,0,200,50);
        namodar_azmon_be_azmon.setBackground(Color.cyan);
        namodar_azmon_be_azmon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Namodar namodar = new Namodar(creator,signin);
            }
        });
        JButton namodar_students = new JButton("Namodar Student Azmon");
        namodar_students.setBounds(0,60,200,50);
        namodar_students.setBackground(Color.cyan);
        namodar_students.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Namodar_Students namodar_students1 = new Namodar_Students(creator,signin);
            }
        });
        JButton excl_azmon = new JButton("Excel Azmon be Azmon");
        excl_azmon.setBounds(0,120,200,50);
        excl_azmon.setBackground(Color.cyan);
        excl_azmon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Excel_Azmon excel_azmon = new Excel_Azmon();
                Object[][] objects =  excel_azmon.excel_azmon(creator);

                Excel_Azmon_be_Azmon excel_azmon_be_azmon = new Excel_Azmon_be_Azmon(objects,creator);
            }
        });

        JButton excel_1azmon = new JButton("Excel 1 Azmon");
        excel_1azmon.setBackground(Color.cyan);
        excel_1azmon.setBounds(0,180,200,50);
        excel_1azmon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Excel_1Azmon excel_1Azmon = new Excel_1Azmon(creator,signin);
            }
        });

        JButton history = new JButton("Tarikhche Azmon ha");
        history.setBounds(700,400,200,200);
        ImageIcon hi = new ImageIcon("Images/history_logo.jpg");
        history.setIcon(hi);

        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                History history1 = new History(creator,signin);
            }
        });

        JLabel label  = new JLabel();
        label.setBounds(0,0,1400,750);
        ImageIcon la = new ImageIcon("Images/untitled.png");
        label.setIcon(la);

        label.add(back);
        label.add(jLabel);
        label.add(history);
        jLabel.add(excel_1azmon);
        jLabel.add(excl_azmon);
        jLabel.add(namodar_students);
        jLabel.add(namodar_azmon_be_azmon);
        label.add(tashih);
        label.add(All);
        label.add(tedad);
        label.add(Separate);
        label.add(Azmon);
        signin.add(label);
        signin.setLayout(null);
        signin.setVisible(true);
    }
}
