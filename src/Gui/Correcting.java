package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import static Gui.Sign_In_Student.tarahi_azmon;
import static Gui.Sign_In_Student.timeAzmon;

public class Correcting {
    JFrame framec;
    int x =0;
    int h=0;
    JButton back = new JButton("Back");
    public Correcting(JFrame frame,String creator)
    {
        System.out.println(creator);
        frame.setVisible(false);
        correct(creator);
        back.setBounds(0,0,190,54);
        ImageIcon ba = new ImageIcon("Images/back.jpg");
        back.setIcon(ba);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                framec.setVisible(false);

            }
        });
    }

    public void correct(String creator) {
        framec = new JFrame();
        framec.setExtendedState(framec.MAXIMIZED_BOTH);
        framec.setTitle("Correcting");

        JLabel label = new JLabel();
        label.setBounds(0,0,1400,750);
        ImageIcon imageIcon = new ImageIcon("Images/check.jpg");
        label.setIcon(imageIcon);
        label.add(back);

        framec.add(label);

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
                Tarahi_Azmon tarahiAzmon= (Tarahi_Azmon) objectOutputStream.readObject();

                    if (creator.equals(tarahiAzmon.creator)){

                        JButton buttonazmon = new JButton(line);
                        buttonazmon.setBackground(Color.yellow);
                        buttonazmon.setBounds(1260,x,120,40);
                        x+=40;
                        label.add(buttonazmon);
                        buttonazmon.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                framec.setVisible(false);
                                JFrame frame = new JFrame();
                                frame.setExtendedState(frame.MAXIMIZED_BOTH);

                                JButton mainback = new JButton();
                                mainback.setBounds(0,0,190,54);
                                ImageIcon ba2 = new ImageIcon("Images/back.jpg");
                                mainback.setIcon(ba2);
                                mainback.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        framec.setVisible(true);
                                        frame.setVisible(false);
                                    }
                                });

                                frame.setLayout(null);
                                frame.setVisible(true);
                                JLabel label1 = new JLabel();
                                label1.setBounds(0,0,1400,750);
                                ImageIcon imag = new ImageIcon("Images/check.jpg");
                                label1.setIcon(imag);
                                label1.add(mainback);


                                for (int i = 0 ; i < tarahiAzmon.attends.size() ; i++) {
                                    File file = new File(buttonazmon.getText()+"/"+tarahiAzmon.attends.get(i)+".txt");
                                    FileInputStream fileOutputStream2 = null;
                                    try {
                                        FileInputStream fileOutputStream = new FileInputStream(file);
                                        ObjectInputStream objectOutputStream = new ObjectInputStream(fileOutputStream);
                                        Tarahi_Azmon tarahi_azmon2 = (Tarahi_Azmon) objectOutputStream.readObject();


                                        JButton button = new JButton(tarahiAzmon.attends.get(i));
                                        button.setBackground(Color.green);
                                        button.setBounds(1260, h, 120, 40);
                                        h += 40;
                                        label1.add(button);
                                        frame.add(label1);
                                        button.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                for (int j = 0; j <tarahi_azmon2.tedadsoal-1 ; j++) {
                                                    tarahi_azmon2.nomarart[j].setEnabled(true);
                                                }
                                                tarahi_azmon2.nomrehjam.setEnabled(true);
                                                tarahi_azmon2.tarahi_azmon(frame);
                                                for (int j = 0; j <tarahi_azmon2.soalat.length ; j++) {
                                                    tarahi_azmon2.soalat[j].action();
                                                }
                                                tarahi_azmon2.chat.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        Chat chat = new Chat(tarahi_azmon2.nameazmon.getText(),creator);
                                                    }
                                                });
                                                tarahi_azmon2.save.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        try {
                                                            for (int j = 0; j <tarahi_azmon2.tedadsoal-1 ; j++) {
                                                                tarahi_azmon2.nomarart[j].setEditable(false);
                                                            }
                                                            tarahi_azmon2.nomrehjam.setEditable(false);
                                                            FileOutputStream  fileOutputStream = new FileOutputStream(file);
                                                            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
                                                            outputStream.writeObject(tarahi_azmon2);
                                                        } catch (FileNotFoundException fileNotFoundException) {
                                                            fileNotFoundException.printStackTrace();
                                                        } catch (IOException ioException) {
                                                            ioException.printStackTrace();
                                                        }
                                                    }
                                                });
                                            }
                                        });
                                    } catch (FileNotFoundException fileNotFoundException) {
                                        fileNotFoundException.printStackTrace();
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    } catch (ClassNotFoundException classNotFoundException) {
                                        classNotFoundException.printStackTrace();
                                    }
                                }
                            }
                        });
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        framec.setLayout(null);
        framec.setVisible(true);
    }
}

