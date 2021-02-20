package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class History {
    JFrame jFrame;
    JLabel label;
    int x=0;
    JButton back = new JButton();
    public History(String creator , JFrame frame)
    {

        frame.setVisible(false);
        jFrame = new JFrame();
        jFrame.setExtendedState(jFrame.MAXIMIZED_BOTH);

        back.setBounds(20,0,200,54);
        ImageIcon ba = new ImageIcon("Images/back.jpg");
        back.setIcon(ba);

        jFrame.setLayout(null);
        jFrame.setVisible(true);
        label  = new JLabel();
        label.setBounds(30,0,1300,720);
        ImageIcon imageIcon = new ImageIcon("Images/history.jpg");
        label.setIcon(imageIcon);
        label.add(back);
        jFrame.add(label);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                frame.setVisible(true);
            }
        });

        history(creator);



    }

    public void history(String creator)
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
                Tarahi_Azmon tarahiAzmon = (Tarahi_Azmon) objectOutputStream.readObject();

                if (creator.equals(tarahiAzmon.creator)) {
                    JButton button = new JButton(line);
                    button.setBounds(1200,x,100,40);
                    x+=40;
                    button.setBackground(Color.orange);
                    label.add(button);
                    button.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            FileInputStream fileOutputStream = null;
                            Tarahi_Azmon tarahiAzmon2 = null;
                            try {
                                fileOutputStream = new FileInputStream("Exams/" + button.getText() + ".txt");
                                ObjectInputStream objectOutputStream = new ObjectInputStream(fileOutputStream);
                                tarahiAzmon2 = (Tarahi_Azmon) objectOutputStream.readObject();

                            } catch (FileNotFoundException fileNotFoundException) {
                                fileNotFoundException.printStackTrace();
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            } catch (ClassNotFoundException classNotFoundException) {
                                classNotFoundException.printStackTrace();
                            }
                            JFrame frame = new JFrame();
                            String information="";
                            frame.setBounds(300,200,700,400);
                            frame.setLayout(null);
                            frame.setVisible(true);
                            JTextArea label2 = new JTextArea();
                            label2.setBounds(0,0,700,400);
                            label2.setOpaque(true);
                            label2.setBackground(Color.yellow);
                            information+="Hour start : "+tarahiAzmon2.hourstart+"  Hour over : "+tarahiAzmon2.hourover+"\n\n\n";
                            information+="Attends : ";
                            for (int i = 0; i <tarahiAzmon2.attends.size() ; i++) {
                                information+=tarahiAzmon2.attends.get(i)+" ";
                            }
                            information+="\n\n";
                            information+="Mahromin : ";
                            for (int i = 0; i <tarahiAzmon2.mahromin.size() ; i++) {
                                information+=tarahiAzmon2.mahromin.get(i);
                            }
                            label2.setText(information);
                            frame.add(label2);
                        }
                    });
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
