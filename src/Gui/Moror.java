package Gui;

import Code.WriteObject;
import Gui.Qustions.Soal_Explain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Moror {
    int z=10;
    JFrame jFrame;
    JLabel label;
    JButton back2 = new JButton();
    public Moror(JFrame frame,String username)

    {


        frame.setVisible(false);
        jFrame = new JFrame();
        jFrame.setExtendedState(jFrame.MAXIMIZED_BOTH);
        jFrame.setTitle("Moror");

        jFrame.setLayout(null);
        jFrame.setVisible(true);
        label = new JLabel();
        ImageIcon imageIcon = new ImageIcon("Images/pen.jpg");
        label.setBounds(30,0,1300,720);
        label.setIcon(imageIcon);

        back2.setBounds(0,0,200,54);
        ImageIcon ba = new ImageIcon("Images/back.jpg");
        back2.setIcon(ba);
        label.add(back2);

        back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                jFrame.setVisible(false);
            }
        });

        jFrame.add(label);



        moror(username);

    }

    public void moror(String username)

    {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Files/ListAzmonHa.txt"));
            int z = 10;
            while (true) {

                String line = bufferedReader.readLine();

                if (line == null) {
                    break;
                }


                FileInputStream fileOutputStream = new FileInputStream("Exams/" + line + ".txt");
                ObjectInputStream objectOutputStream = new ObjectInputStream(fileOutputStream);
                Tarahi_Azmon tarahi_azmon = (Tarahi_Azmon) objectOutputStream.readObject();
                for (int i = 0; i <tarahi_azmon.attends.size() ; i++) {
                    if (username.equals(tarahi_azmon.attends.get(i)))
                    {

                        File file = new File(line+"/"+username+".txt");
                        FileInputStream fileOutputStream2 = new FileInputStream(file);
                        ObjectInputStream objectOutputStream2 = new ObjectInputStream(fileOutputStream2);
                        Tarahi_Azmon tarahi_azmon2 = (Tarahi_Azmon) objectOutputStream2.readObject();
                        JButton button  = new JButton(line);
                        button.setBackground(Color.orange);
                        button.setBounds(1200, z, 100, 40);
                        z += 40;
                        label.add(button);
                        button.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (tarahi_azmon2.moror.isSelected()) {
                                    for (int j = 0; j <tarahi_azmon2.tedadsoal-1 ; j++) {
                                        tarahi_azmon2.soalat[j].action();
                                        tarahi_azmon2.nomarart[j].setEnabled(true);
                                        tarahi_azmon2.nomarart[j].setEditable(false);
                                    }

                                    tarahi_azmon2.tarahi_azmon(jFrame);
                                    tarahi_azmon2.save.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            WriteObject writeObject = new WriteObject();
                                            writeObject.writeobject(line + "/" + username + ".txt", tarahi_azmon2);
                                        }
                                    });
                                    tarahi_azmon2.chat.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            Chat cah = new Chat(tarahi_azmon2.nameazmon.getText(), username);
                                        }
                                    });
                                }
                            }
                        });

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

    }

}
