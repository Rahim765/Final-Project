package Gui;

import Code.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static Code.RandomNumber.generateRandom;

public class Sign_In_Student {
    static boolean avali=true;
    boolean attend = false;
    String username;
    boolean back = true;
    static int page2 = 0 ;
    static int x=0;
    int x2=0;
    boolean yes;
    int [] tartib;
    JFrame sing_in;
    boolean mahrom =false;
    static int Timer=0;
    static Tarahi_Azmon tarahi_azmon=null;
    static int second = 0;
    static int timeAzmon= 0;
    static int secondseparat=0,secondseparat2=0,minuteseparat=0,minuteseparat2=0;
    static int Secondall=0,Secondall2=0,minuteall =0,minuteall2 =0;
    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {

            secondseparat++;

            if (secondseparat==10)
            {
                secondseparat2++;
                secondseparat=0;
                if (secondseparat2==6)
                {
                    secondseparat2=0;
                    minuteseparat++;
                    if (minuteseparat==10)
                    {
                        minuteseparat=0;
                        minuteseparat2++;
                    }
                }
            }
            Secondall++;
            if (Secondall==10)
            {
                Secondall=0;
                Secondall2++;
                if (Secondall2==6)
                {
                    Secondall2=0;
                    minuteall++;
                    if (minuteall==10)
                    {
                        minuteall=0;
                        minuteall2++;
                    }
                }
            }

            String g = ""+minuteall2+minuteall+":"+Secondall2+Secondall;
            tarahi_azmon.timeazmon.setText(g);

            String x2= ""+minuteseparat2+minuteseparat+":"+secondseparat2+secondseparat;
            tarahi_azmon.clock.setText(x2);

            second++;
            timeAzmon++;
            if (second==(int)(Double.parseDouble(zaman[Timer])*60))
            {
                secondseparat=0;
                secondseparat2=0;
                minuteseparat2=0;
                minuteseparat=0;

                tarahi_azmon.next.setEnabled(true);
                tarahi_azmon.previose.setEnabled(true);
                timerTask.cancel();
                Timer++;
                tarahi_azmon.next.doClick();
            }

        }
    };
    public void start()
    {
        timer.scheduleAtFixedRate(timerTask,1000,1000);
    }


    Timer timer2 = new Timer();
    TimerTask timerTask2 = new TimerTask() {
        @Override
        public void run() {
            Secondall++;
            if (Secondall==10)
            {
                Secondall=0;
                Secondall2++;
                if (Secondall2==6)
                {
                    Secondall2=0;
                    minuteall++;
                    if (minuteall==10)
                    {
                        minuteall=0;
                        minuteall2++;
                    }
                }
            }

            String g = ""+minuteall2+minuteall+":"+Secondall2+Secondall;
            tarahi_azmon.timeazmon.setText(g);



            timeAzmon++;
            if (timeAzmon == Integer.parseInt(tarahi_azmon.timeAzmon.getText())*60)
            {
                timerTask2.cancel();
                tarahi_azmon.frame.setVisible(false);
                tarahi_azmon.save.doClick();
                avali=true;
            }
        }
    };

    public void start2()
    {
        timer2.scheduleAtFixedRate(timerTask2,1000,1000);
    }


    static String[] zaman;
    static int page =0;

    public Sign_In_Student(){}
    LogIn s = new LogIn();
    JLabel mahroom = new JLabel();
    JLabel label = new JLabel();
    ImageIcon imageIcon = new ImageIcon("Images/untitled.png");
    JButton back2 = new JButton();
    JButton moror = new JButton("Moror");

    public Sign_In_Student(JFrame frame, String username , String password) {

        if (s.check_sign_in(username ,password,"Files/Form_SabtName.txt",3,4))
        {
            frame.setVisible(false);
            sing_in(username,frame);
            mahroom.setOpaque(true);
            mahroom.setBackground(Color.orange);
            mahroom.setBounds(600,0,200,40);

            moror.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Moror moror = new Moror(sing_in,username);
                }
            });

            back2.setBounds(0,0,200,54);
            ImageIcon ba = new ImageIcon("Images/back.jpg");
            back2.setIcon(ba);
            label.add(back2);

            back2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(true);
                    sing_in.setVisible(false);
                }
            });
            label.setBounds(40,0,1300,720);
            label.setIcon(imageIcon);
            sing_in.add(label);
        }

    }
    public void sing_in(String username,JFrame frame2)
    {

        sing_in = new JFrame();
        sing_in.setTitle("Sign In");
        sing_in.setExtendedState(sing_in.MAXIMIZED_BOTH);
        label.add(mahroom);
        moror.setBounds(100,100,200,150);
        moror.setBackground(Color.orange);
        label.add(moror);
        this.username = username;
        try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("Files/ListAzmonHa.txt"));
            int z=10;
            while (true)
            {

                String line = bufferedReader.readLine();

                if (line==null) {
                    break;
                }

                FileInputStream fileOutputStream = new FileInputStream("Exams/"+line+".txt");
                ObjectInputStream objectOutputStream = new ObjectInputStream(fileOutputStream);
                tarahi_azmon = (Tarahi_Azmon) objectOutputStream.readObject();

                for (int i = 0; i <tarahi_azmon.list_daneshjo.size() ; i++) {
                    if (username.equals(tarahi_azmon.list_daneshjo.get(i))) {
                        for (int j = 0; j < tarahi_azmon.attends.size(); j++) {
                            if (username.equals(tarahi_azmon.attends.get(j))) {
                                attend = true;
                            }

                        }
                      
                        if (attend == false) {
                            JButton button = new JButton(line);
                            button.setBounds(1200, z, 100, 40);
                            label.add(button);
                            button.setBackground(Color.yellow);
                            JLabel label = new JLabel();
                            label.setBounds(980,z,220,40);
                            label.setOpaque(true);
                            label.setBackground(Color.white);
                            label.setText("H start :"+String.valueOf(tarahi_azmon.hourstart) +":"+tarahi_azmon.minutestart+
                                    " H over : "+tarahi_azmon.hourover+":"+ tarahi_azmon.minuteover +" Time : "+tarahi_azmon.timeAzmon.getText());
                            this.label.add(label);
                            z+=40;
                            button.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    for (int j = 0; j < tarahi_azmon.mahromin.size(); j++) {
                                        if (tarahi_azmon.mahromin.get(j).equals(username)) {
                                            mahrom = true;
                                        }
                                    }
                                    if (mahrom == false) {
                                        try {
                                            System.out.println(button.getText());
                                            FileInputStream fileOutputStream = new FileInputStream("Exams/" + button.getText() + ".txt");
                                            ObjectInputStream objectOutputStream = new ObjectInputStream(fileOutputStream);
                                            tarahi_azmon = (Tarahi_Azmon) objectOutputStream.readObject();
                                            System.out.println(tarahi_azmon.nameazmon.getText());
                                        } catch (FileNotFoundException fileNotFoundException) {
                                            fileNotFoundException.printStackTrace();
                                        } catch (IOException ioException) {
                                            ioException.printStackTrace();
                                        } catch (ClassNotFoundException classNotFoundException) {
                                            classNotFoundException.printStackTrace();
                                        }
                                        tarahi_azmon.attends.add(username);
                                        for (int j = 0; j < tarahi_azmon.soalat.length; j++) {
                                            tarahi_azmon.soalat[j].action();
                                        }
                                        System.out.println(button.getText());
                                        try {
                                            File file = new File("Exams/" + button.getText() + ".txt");
                                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                                            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
                                            outputStream.writeObject(tarahi_azmon);

                                        } catch (FileNotFoundException fileNotFoundException) {
                                            fileNotFoundException.printStackTrace();
                                        } catch (IOException ioException) {
                                            ioException.printStackTrace();
                                        }
                                        System.out.println(tarahi_azmon.attends.size());
                                        System.out.println(tarahi_azmon.Tarh);

                                        File file2 = new File(button.getText() + "/" +
                                                username + ".txt");
                                        try {
                                            file2.createNewFile();
                                        } catch (IOException ioException) {
                                            ioException.printStackTrace();
                                        }

                                        System.out.println(tarahi_azmon.mahromin.size());


                                            tartib = generateRandom(tarahi_azmon.tedadsoal - 1);

                                            System.out.println(tarahi_azmon.tedadsoal - 1);

                                            for (int j = 0; j < tartib.length; j++) {
                                                System.out.print(tartib[j] + "   ");
                                                if (j == tartib.length - 1) {
                                                    System.out.println();
                                                }
                                            }

                                            SimpleDateFormat parser = new SimpleDateFormat("HH:mm");

                                            Date date = new Date();

                                            int x = (int) date.getHours();
                                            int y = (int) date.getMinutes();


                                            tarahi_azmon.chat.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    Chat chat = new Chat(tarahi_azmon.nameazmon.getText(), username);
                                                }
                                            });
                                            if (tarahi_azmon.localDate.equals(LocalDate.now())) {


                                                if (tarahi_azmon.hourstart == tarahi_azmon.hourover &&
                                                        tarahi_azmon.hourstart == x) {
                                                    if (tarahi_azmon.minutestart <= y && tarahi_azmon.minuteover >= y) {
                                                        tarahi_azmon.tarahi_azmon(sing_in);
                                                        yes = true;
                                                        System.out.println("salam1");
                                                    }
                                                } else if (tarahi_azmon.hourstart != tarahi_azmon.hourover) {
                                                    if (x == tarahi_azmon.hourstart && tarahi_azmon.minutestart <= y) {
                                                        tarahi_azmon.tarahi_azmon(sing_in);
                                                        yes = true;
                                                        System.out.println("salam2");

                                                    } else if (tarahi_azmon.hourover == x && tarahi_azmon.minuteover >= y) {
                                                        tarahi_azmon.tarahi_azmon(sing_in);
                                                        yes = true;
                                                        System.out.println("salam3");

                                                    } else if (tarahi_azmon.hourstart!=x&&tarahi_azmon.hourstart < x && tarahi_azmon.hourover > x&&tarahi_azmon.hourover!=x) {
                                                        System.out.println("salam4");
                                                        tarahi_azmon.tarahi_azmon(sing_in);
                                                        yes = true;

                                                    }
                                                }
                                            }
                                            tarahi_azmon.save.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    tarahi_azmon.Next=true;
                                                    if (tarahi_azmon.autoscore.isSelected()) {
                                                        Tashih tashih = new Tashih(tarahi_azmon);
                                                    }
                                                    tarahi_azmon.frame.setVisible(false);
                                                   frame2.setVisible(true);
                                                    Disable disable = new Disable(tarahi_azmon);
                                                    WriteObject writeObject = new WriteObject();
                                                    writeObject.writeobject(button.getText() + "/" +
                                                            username + ".txt", tarahi_azmon);


                                                }
                                            });


                                            tarahi_azmon.previose.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    if (tarahi_azmon.tartib.isSelected()) {
                                                        batartiballback();
                                                    }
                                                    else
                                                        betartibback();
                                                }
                                            });
                                            tarahi_azmon.next.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {


                                                    if (yes == true && tarahi_azmon.separate == true && !tarahi_azmon.taratib) {

                                                        betartib();
                                                    } else if (yes == true && tarahi_azmon.separate == true && tarahi_azmon.taratib) {
                                                        batartib();
                                                    } else if (yes == true && tarahi_azmon.separate == false && tarahi_azmon.taratib) {
                                                        batartibAll();
                                                    } else if (yes == true && tarahi_azmon.separate == false && !tarahi_azmon.taratib) {
                                                        betratibAll();
                                                    }


                                                }
                                            });

                                        } else {
                                            mahroom.setText("Az in Emtahan mahroom hasted");
                                            mahrom = false;
                                        }

                                }
                            });
                        }
                        else
                            {
                                attend=false;
                            }


                    }
                }


            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        sing_in.setLayout(null);
        sing_in.setVisible(true);
    }

public void betartib()
{
    if (Timer == tarahi_azmon.tedadsoal - 1) {

        tarahi_azmon.save.doClick();

    } else {
        second = 0;

        if (page < tarahi_azmon.tedadsoal - 1) {
            tarahi_azmon.questions[page].setVisible(false);
            page += 1;
            tarahi_azmon.frame.add(tarahi_azmon.questions[page]);
            tarahi_azmon.questions[page].setVisible(true);
        }
        tarahi_azmon.next.setEnabled(false);
        tarahi_azmon.previose.setEnabled(false);
        zaman = new String[tarahi_azmon.tedadsoal - 1];
        zaman = tarahi_azmon.zaman;

        Sign_In_Student sign_in_student = new Sign_In_Student();
        sign_in_student.start();


    }
}

    public void batartib()
    {
        if (Timer == tarahi_azmon.tedadsoal - 1) {

            tarahi_azmon.save.doClick();
        } else {
            second = 0;
            if (page < tarahi_azmon.tedadsoal - 1) {
                tarahi_azmon.questions[x].setVisible(false);
             //   tarahi_azmon.frame.add(tarahi_azmon.questions[tartib[page]]);
                tarahi_azmon.questions[tartib[page]].setVisible(true);
                page += 1;
                x=tartib[page-1];
            }
            tarahi_azmon.next.setEnabled(false);
            tarahi_azmon.previose.setEnabled(false);
            zaman = new String[tarahi_azmon.tedadsoal - 1];
            zaman = tarahi_azmon.zaman;
            Sign_In_Student sign_in_student = new Sign_In_Student();

            sign_in_student.start();


        }
    }
    public void batartibAll()
    {
        if (page < tarahi_azmon.tedadsoal - 1) {
            back=true;
            tarahi_azmon.questions[x].setVisible(false);
            //   tarahi_azmon.frame.add(tarahi_azmon.questions[tartib[page]]);
            tarahi_azmon.questions[tartib[page]].setVisible(true);
            page += 1;
            x=tartib[page-1];
        }
        if (avali) {
            Sign_In_Student sign = new Sign_In_Student();
            sign.start2();
            avali=false;
        }

    }

    public void batartiballback()
    {
        if (page >0) {
            if (back&&page>1)
            {
                page-=2;
                back=false;
            }
            else
                {
                    page-=1;
                }
            tarahi_azmon.questions[x].setVisible(false);
            tarahi_azmon.questions[tartib[page]].setVisible(true);
            x=tartib[page];

        }

    }
    public void betartibback()
    {
        if (page > 0) {
            tarahi_azmon.questions[page].setVisible(false);
            page--;
            tarahi_azmon.questions[page].setVisible(true);
        }
    }

    public void betratibAll()
    {
        if (page<tarahi_azmon.tedadsoal-1) {
            tarahi_azmon. questions[page].setVisible(false);
            page+=1;
            tarahi_azmon. frame.add(tarahi_azmon.questions[page]);
            tarahi_azmon.  questions[page].setVisible(true);
        }
        if (avali) {
            Sign_In_Student sign = new Sign_In_Student();
            sign.start2();
            avali=false;
        }

    }

}
