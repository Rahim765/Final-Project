package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Chat {
    boolean yes = true;
    File file1;
    String nameazmon;
    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            BufferedReader bufferedReader;
            PrintWriter printWriter;
            try {
                bufferedReader = new BufferedReader(new FileReader(file1));
                while (true)
                {
                    String line = bufferedReader.readLine();

                    if (line==null) {
                        break;
                    }

                    message = message+line+"\n";
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }


            try {
                printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file1)));
                printWriter.print(message);
                jTextArea.setText(message);
                message="";
                printWriter.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    };
    public void start()
    {
        timer.scheduleAtFixedRate(timerTask,1000,1000);
    }



    String message="";
    JFrame jframe;
    TextArea jTextArea = new TextArea();
    JButton button = new JButton("Send");
    JTextField msg = new JTextField();
    JLabel label = new JLabel();

    public Chat(String nameAzmon,String name)
    {
        this.nameazmon = nameAzmon;

        jframe = new JFrame();
        jframe.setExtendedState(jframe.MAXIMIZED_BOTH);
        jframe.setLayout(null);
        jframe.setVisible(true);


        chat(nameAzmon,name);
    }

    public void chat(String nameazmon,String name)
    {

        file1 = new File("Chat/"+nameazmon+"chat.txt");
        if (!file1.exists())
        {
            try {
                file1.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        jTextArea.setBounds(50,50,1200,600);
        jframe.add(jTextArea);
        jTextArea.setBackground(Color.cyan);
        jTextArea.setEditable(false);

        label.setBounds(700,0,100,40);
        label.setOpaque(true);
        label.setBackground(Color.green);
        label.setText(nameazmon);
        label.setHorizontalAlignment(JLabel.CENTER);
        jframe.add(label);

        JScrollPane scroll = new JScrollPane(jTextArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jframe.add(scroll);


        msg.setBounds(50,660,1000,40);
        msg.setOpaque(true);
        msg.setBackground(Color.yellow);


        button.setBounds(1100,660,100,40);
        button.setBackground(Color.orange);
        if (yes) {
            start();
            yes = false;
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PrintWriter printWriter = null;
                try {
                    printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file1,true)));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                Date date = new Date();
                int x = date.getHours();
                int y  = date.getMinutes();
                int z = date.getSeconds();
                String time = ""+x+":"+y+":"+z;
                printWriter.print(name+"\n"+msg.getText()+"\n"+time+"\n\n");
                msg.setText("");
                printWriter.flush();
            }
        });

        jframe.add(jTextArea);
        jframe.add(msg);
        jframe.add(button);
    }

}
