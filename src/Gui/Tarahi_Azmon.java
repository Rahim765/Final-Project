package Gui;

import Code.*;
import Gui.Qustions.Soal;
import Gui.Qustions.Soal_Explain;
import Gui.Qustions.Soal_Testi;
import Gui.Qustions.Soal_TrueFalse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Tarahi_Azmon implements Serializable {

    boolean Next=true;
    int soalc=0;
    boolean Tarh=true;
   public String creator;
   public ArrayList<String> attends = new ArrayList<>();
    boolean separate = false;
    String[] zaman;
    JTextField[] time;
    LogIn l = new LogIn();
    JFrame frame  = new JFrame();
    JLabel[] questions ;
    public  int page=0;
    JButton next = new JButton("=>");
    JButton previose = new JButton("<=");
    JLabel[] safha ;
    boolean aval=true;
    JButton back  = new JButton("Main Menu");
    JButton save = new JButton("Save");
    JTextArea student_name = new JTextArea();
    JLabel studentname = new JLabel("Name");
    JTextArea student_lastname = new JTextArea();
    JLabel stdentlastname = new JLabel("Last Name");
    JTextArea student_Id = new JTextArea();
    JLabel studentid = new JLabel("ID");
    JButton add = new JButton("Add");
    public ArrayList<String> list_daneshjo = new ArrayList<String>();
    JTextArea filepath = new JTextArea();
    JButton addfromfile = new JButton("ADD");
    JTextField year = new JTextField();
    JTextField month = new JTextField();
    JTextField day = new JTextField();
    public LocalDate localDate;
    JTextField hour = new JTextField();
    JTextField hour2 = new JTextField();
    JTextField hour3 = new JTextField();
    JTextField hour4 = new JTextField();
    JTextField timeAzmon = new JTextField();
    public JTextField nameazmon = new JTextField();
    JRadioButton explain = new JRadioButton("Explain");
    JRadioButton testi = new JRadioButton("Testi");
    JRadioButton TrueFalse = new JRadioButton("TrueFalse");
    boolean[] yes ;
    boolean teacher = true;
    public int tedadsoal = 0 ;
    int hourstart,minutestart,hourover , minuteover;
    JTextField mahrom = new JTextField();
    JButton addmahrom = new JButton("Add");
    ArrayList<String> mahromin = new ArrayList<>();
    JLabel clock = new JLabel();
    JLabel timeazmon = new JLabel();
    JCheckBox tartib = new JCheckBox("Tartib");
    boolean taratib;
    public JTextField[] nomarart;
    public JTextField nomrehjam = new JTextField();
    JCheckBox moror = new JCheckBox("Moror");
    public Soal[] soalat;
    JCheckBox hard = new JCheckBox("Hard");
    JCheckBox normal = new JCheckBox("Normal");
    JCheckBox easy = new JCheckBox("Easy");
    public JButton chat = new JButton("Chat");
    public JCheckBox autoscore = new JCheckBox("Tashih");
    public Tarahi_Azmon(JFrame frame2,int tedad,JCheckBox separate,String creator)
    {
        this.creator=creator;
        nomarart = new JTextField[tedad-1];
        if (separate.isSelected())
        {
            this.separate = true;
        }
        zaman = new String[tedad];
        yes = new boolean[tedad];
        safha = new JLabel[tedad];
        questions = new JLabel[tedad];
        time = new JTextField[tedad-1];
        soalat = new Soal[tedad-1];

        this.tedadsoal=tedad;
        for (int page = 0; page <tedadsoal ; page++) {
            questions[page] = new JLabel();
            safha[page]=new JLabel();

        }
        if (separate.isSelected())
        {
            int x=350;
            for (int i = 0; i <tedadsoal-1 ; i++) {
                time[i] = new JTextField();
                time[i].setBounds(x,670,50,30);
                time[i].setBackground(Color.orange);
                frame.add(time[i]);
                x+=60;
            }
        }
        tarahi_azmon(frame2);

        int z=0;
        for (int i = 0; i <tedadsoal-1 ; i++) {
            nomarart[i] = new JTextField();
            nomarart[i].setBounds(1210,z,150,35);
            nomarart[i].setBackground(Color.orange);
            nomarart[i].setHorizontalAlignment(JTextField.CENTER);
            nomarart[i].setEnabled(false);
            nomarart[i].setForeground(Color.RED);
            frame.add(nomarart[i]);
            z+=35;
        }
    }
public void init()
{
    nomrehjam.setBounds(1210,560,150,40);
    nomrehjam.setBackground(Color.orange);
    nomrehjam.setHorizontalAlignment(JTextField.CENTER);
    nomrehjam.setSelectedTextColor(Color.red);
    nomrehjam.setForeground(Color.red);

    clock.setBounds(1200,670,100,30);
    clock.setOpaque(true);
    clock.setBackground(Color.orange);
    frame.add(clock);
    timeazmon.setBounds(1200,640,100,30);
    timeazmon.setOpaque(true);
    timeazmon.setBackground(Color.yellow);
    frame.add(timeazmon);


    mahrom.setBounds(1000,400,150,50);
    mahrom.setBackground(Color.red);

    addmahrom.setBounds(1040,490,70,30);
    addmahrom.setBackground(Color.red);


    next.setBounds(0,600,150,50);
    ImageIcon imagenext = new ImageIcon("Images/next.jpg");
    next.setIcon(imagenext);

    explain.setBounds(50,670,90,20);
    explain.setBackground(Color.orange);
    testi.setBounds(150,670,90,20);
    testi.setBackground(Color.orange);
    TrueFalse.setBounds(250,670,90,20);
    TrueFalse.setBackground(Color.orange);
    ButtonGroup group =new ButtonGroup();
    group.add(explain);
    group.add(testi);
    group.add(TrueFalse);

    chat.setBounds(1000,300,100,40);
    chat.setBackground(Color.orange);

    previose.setBounds(220,600,150,50);
    ImageIcon imageback = new ImageIcon("Images/back2.jpg");
    previose.setIcon(imageback);

    back.setBounds(1000,600,150,60);
    back.setBackground(Color.orange);

    save.setBounds(600,600,150,50);
    ImageIcon imageIconsave = new ImageIcon("Images/save.png");
    save.setIcon(imageIconsave);

    hard.setBounds(770,560,80,40);
    hard.setBackground(Color.orange);

    normal.setBounds(870,560,80,40);
    normal.setBackground(Color.orange);

    easy.setBounds(970,560,80,40);
    easy.setBackground(Color.orange);

    student_name.setBounds(100,200,130,30);
    student_name.setBackground(Color.orange);
    studentname.setBounds(0,200,80,30);
    studentname.setOpaque(true);
    studentname.setBackground(Color.orange);

    student_lastname.setBounds(100,240,130,30);
    student_lastname.setBackground(Color.orange);
    stdentlastname.setBounds(0,240,80,30);
    stdentlastname.setOpaque(true);
    stdentlastname.setBackground(Color.orange);

    student_Id.setBounds(100,280,130,30);
    student_Id.setBackground(Color.orange);
    studentid.setBounds(0,280,80,30);
    studentid.setOpaque(true);
    studentid.setBackground(Color.orange);

    add.setBounds(250,240,80,40);
    add.setBackground(Color.orange);

    filepath.setBackground(Color.orange);
    filepath.setBounds(100,400,500,40);
    addfromfile.setBackground(Color.orange);
    addfromfile.setBounds(300,460,100,50);

    JLabel labeldate = new JLabel("Date :");
    labeldate.setBounds(130,0,60,30);
    labeldate.setOpaque(true);
    labeldate.setBackground(Color.orange);

    year.setBounds(200,0,70,30);
    year.setBackground(Color.orange);
    year.setHorizontalAlignment(JTextField.CENTER);

    month.setBounds(280,0,70,30);
    month.setBackground(Color.orange);
    month.setHorizontalAlignment(JTextField.CENTER);

    day.setBounds(360,0,70,30);
    day.setBackground(Color.orange);
    day.setHorizontalAlignment(JTextField.CENTER);

    JLabel labelhour = new JLabel("Hour start : ");
    labelhour.setBounds(110,80,80,30);
    labelhour.setOpaque(true);
    labelhour.setBackground(Color.ORANGE);

    JLabel labelhour2 = new JLabel("Hour over : ");
    labelhour2.setBounds(340,80,80,30);
    labelhour2.setOpaque(true);
    labelhour2.setBackground(Color.ORANGE);

    JLabel labelhour3 = new JLabel("Time Exam : ");
    labelhour3.setBounds(570,80,80,30);
    labelhour3.setOpaque(true);
    labelhour3.setBackground(Color.ORANGE);



    hour.setBounds(200,80,60,30);
    hour.setBackground(Color.orange);
    hour.setHorizontalAlignment(JTextField.CENTER);
    hour2.setBounds(270,80,60,30);
    hour2.setBackground(Color.orange);
    hour2.setHorizontalAlignment(JTextField.CENTER);
    hour3.setBounds(430,80,60,30);
    hour3.setBackground(Color.orange);
    hour3.setHorizontalAlignment(JTextField.CENTER);
    hour4.setBounds(500,80,60,30);
    hour4.setBackground(Color.orange);
    hour4.setHorizontalAlignment(JTextField.CENTER);

    timeAzmon.setBounds(660,80,60,30);
    timeAzmon.setBackground(Color.orange);
    timeAzmon.setHorizontalAlignment(JTextField.CENTER);


        tartib.setBounds(1100, 40, 100, 30);
        tartib.setBackground(Color.orange);
        questions[0].add(tartib);

    autoscore.setBounds(1100,80,100,30);
    autoscore.setBackground(Color.orange);
    autoscore.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (autoscore.isSelected())
            {
                explain.setEnabled(false);
            }
            else
                {
                    explain.setEnabled(true);
                }
        }
    });

    moror.setBounds(1100,0,100,30);
    moror.setBackground(Color.orange);

    nameazmon.setBounds(600,0,150,40);
    nameazmon.setBackground(Color.orange);
    nameazmon.setHorizontalAlignment(JTextField.CENTER);

    frame.add(nomrehjam);
    frame.add(previose);
    frame.add(next);
    frame.add(back);
    frame.add(save);
    frame.add(explain);
    frame.add(testi);
    frame.add(TrueFalse);


    questions[0].add(autoscore);
    questions[0].add(chat);
    questions[0].add(hard);
    questions[0].add(normal);
    questions[0].add(easy);
    questions[0].add(labeldate);
    questions[0].add(labelhour3);
    questions[0].add(labelhour);
    questions[0].add(labelhour2);
    questions[0].add(moror);
    questions[0].add(addmahrom);
    questions[0].add(mahrom);
    questions[0].add(nameazmon);
    questions[0].add(hour);
    questions[0].add(hour2);
    questions[0].add(hour3);
    questions[0].add(hour4);
    questions[0].add(timeAzmon);
    questions[0].add(year);
    questions[0].add(month);
    questions[0].add(day);
    questions[0].add(student_name);
    questions[0].add(student_lastname);
    questions[0].add(student_Id);
    questions[0].add(add);
    questions[0].add(studentname);
    questions[0].add(stdentlastname);
    questions[0].add(studentid);
    questions[0].add(filepath);
    questions[0].add(addfromfile);

}
    public void tarahi_azmon(JFrame frame2)
    {

        frame.setTitle("Azmon");
        frame.setExtendedState(frame.MAXIMIZED_BOTH);

        frame.setLayout(null);
        frame.setVisible(true);

        frame2.setVisible(false);


        for (int page = 0; page <tedadsoal ; page++) {

            questions[page].setBounds(0,0,1200,600);
            questions[page].setOpaque(true);
            questions[page].setBackground(Color.blue);
            ImageIcon imageIcon = new ImageIcon("Images/exam.jpg");
            questions[page].setIcon(imageIcon);

            safha[page].setBounds(0,0,50,20);
            safha[page].setOpaque(true);
            safha[page].setBackground(Color.orange);
            safha[page].setText("page : "+String.valueOf(page+1));




            questions[page].add(safha[page]);

        }
        frame.add(questions[page]);

        init();
        change_page(frame2);
    }



    public void change_page(JFrame fra2)
    {
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Next) {
                    if (page < tedadsoal - 1) {
                        questions[page].setVisible(false);
                        page += 1;
                        frame.add(questions[page]);
                        questions[page].setVisible(true);
                    }

                    if (yes[page] == false) {
                        if (explain.isSelected()) {
                            Soal soal = new Soal_Explain(questions[page]);
                            yes[page] = true;
                            soalat[soalc] = soal;
                            soalc++;
                        } else if (testi.isSelected()) {
                            Soal soal = new Soal_Testi(questions[page], autoscore);
                            yes[page] = true;
                            soalat[soalc] = soal;
                            soalc++;

                        } else if (TrueFalse.isSelected()) {
                            Soal soal = new Soal_TrueFalse(questions[page], autoscore);
                            yes[page] = true;
                            soalat[soalc] = soal;
                            soalc++;

                        }
                    }
                }
            }
        });

        previose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (Next) {
                    if (page > 0) {
                        questions[page].setVisible(false);
                        page--;
                        questions[page].setVisible(true);
                    }
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fra2.setVisible(true);
                frame.setVisible(false);
            }
        });


        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Enabel_Disable enabel_disable = new Enabel_Disable();
                enabel_disable.disable(hour,hour2,hour3,hour4,timeAzmon,filepath,addfromfile,nameazmon,student_name,student_lastname,student_Id,
                        add,year,month,day,moror,autoscore,tartib);


                for (int i = 0; i <tedadsoal-1 ; i++) {
                    soalat[i].soal.setEditable(false);
                    if (soalat[i] instanceof Soal_Testi)
                    {
                        Soal_Testi s = (Soal_Testi) soalat[i];
                        for (int j = 0; j <4 ; j++) {
                            s.jTextFieldes[i].setEditable(false);
                        }
                    }
                }

                if (autoscore.isSelected())
                {
                    for (int i = 0; i <tedadsoal-1 ; i++) {
                        if (soalat[i] instanceof Soal_Testi)
                        {
                            Soal_Testi s = (Soal_Testi) soalat[i];
                            s.textField.setVisible(false);
                        }
                        if (soalat[i] instanceof Soal_TrueFalse)
                        {
                            Soal_TrueFalse s = (Soal_TrueFalse) soalat[i];
                            s.textField.setVisible(false);
                        }
                    }
                }


                if (Tarh == true) {
                    Next=false;
                    Tarh=false;
                    File file2 = new File(nameazmon.getText());
                    file2.mkdir();

                    if (tartib.isSelected()) {
                        taratib = true;
                    }
                    if (separate) {
                        for (int i = 0; i < tedadsoal - 1; i++) {
                            zaman[i] = time[i].getText();
                        }
                    }
                    localDate = LocalDate.of(Integer.parseInt(year.getText()),
                            Integer.parseInt(month.getText()), Integer.parseInt(day.getText()));

                    hourstart = Integer.parseInt(hour.getText());
                    minutestart = Integer.parseInt(hour2.getText());
                    hourover = Integer.parseInt(hour3.getText());
                    minuteover = Integer.parseInt(hour4.getText());

                    try {
                        File file = new File("Exams/" + nameazmon.getText() + ".txt");
                        file.createNewFile();

                        ListAzmonHa l = new ListAzmonHa(nameazmon.getText());

                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
                        outputStream.writeObject(Tarahi_Azmon.this);


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (NotSerializableException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    for (int i = 0; i < tedadsoal - 1; i++) {
                        System.out.println(zaman[i]);
                    }
                }
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                list_daneshjo.add(student_Id.getText());
                if (!l.check_sign_in(student_Id.getText(),
                        "Files/Form_SabtName.txt", 3)) {
                    PrintWriter printWriter;
                    try {
                        printWriter = new PrintWriter(new BufferedWriter(
                                new FileWriter("Files/Form_SabtName.txt", true)));
                        printWriter.println(student_name.getText() + " " + student_lastname.getText() + " " +
                                student_Id.getText() + " " + student_Id.getText() + " " + student_Id.getText());
                        printWriter.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                student_Id.setText("");
                student_lastname.setText("");
                student_name.setText("");
            }
        });

        addfromfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReadExcelFile readExcelFile = new ReadExcelFile();
                String path = filepath.getText();
               readExcelFile.readexcelfile2(path);
               readExcelFile.readexcelfile(path,list_daneshjo);
                System.out.println(list_daneshjo.size());
                for (int i = 0; i <list_daneshjo.size() ; i++) {
                    System.out.println(list_daneshjo.get(i));
                }
            }
        });
        addmahrom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mahromin.add(mahrom.getText());
                mahrom.setText("");
            }
        });

        chat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Tarh==true) {
                    Chat chat = new Chat(nameazmon.getText(), creator);
                }
            }
        });
    }

}
