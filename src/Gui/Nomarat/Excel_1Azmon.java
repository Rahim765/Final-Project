package Gui.Nomarat;

import Code.Excel_Azmon;
import Gui.Tarahi_Azmon;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.management.AttributeList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Excel_1Azmon {
    JFrame jFrame;
    int x=0;
    int y=0;
    int sum=0;
    JButton back = new JButton();
    JLabel label = new JLabel();
    public Excel_1Azmon(String creator , JFrame frame)
    {
        frame.setVisible(false);
        jFrame= new JFrame();
        jFrame.setExtendedState(jFrame.MAXIMIZED_BOTH);

        back.setBounds(0,0,200,54);
        ImageIcon ba = new ImageIcon("Images/back.jpg");
        back.setIcon(ba);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                jFrame.setVisible(false);
            }
        });
        label.setBounds(0,0,1400,720);
        ImageIcon imageIcon = new ImageIcon("Images/namodar34.jpg");
        label.setIcon(imageIcon);
        label.add(back);
        jFrame.add(label);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        excel(creator);

    }


    public void excel(String creator)
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Files/ListAzmonHa.txt"));
            int z = 10;
            DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();

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
                    button.setBounds(1280,x,100,40);
                    x+=40;
                    button.setBackground(Color.orange);
                    jFrame.add(button);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            y=0;
                            ArrayList<String> arr = new ArrayList<>();
                            for (int i = 0; i < tarahiAzmon.attends.size(); i++) {
                                arr.add(tarahiAzmon.attends.get(i));
                                File file = new File(button.getText() + "/" + tarahiAzmon.attends.get(i) + ".txt");
                                FileInputStream fileOutputStream2 = null;
                                Tarahi_Azmon tarahi_azmon2 = null;
                                try {
                                    fileOutputStream2 = new FileInputStream(file);
                                    ObjectInputStream objectOutputStream2 = new ObjectInputStream(fileOutputStream2);
                                     tarahi_azmon2 = (Tarahi_Azmon) objectOutputStream2.readObject();

                                } catch (FileNotFoundException fileNotFoundException) {
                                    fileNotFoundException.printStackTrace();
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                } catch (ClassNotFoundException classNotFoundException) {
                                    classNotFoundException.printStackTrace();
                                }


                                sum += Integer.parseInt(tarahi_azmon2.nomrehjam.getText());
                                arr.add(String.valueOf(sum));
                                sum=0;
                            }

                            Object[][]  objects = new Object[arr.size()/2][2];
                            for (int i = 0; i < arr.size(); i+= 2) {
                                objects[y][0] = arr.get(i);
                                objects[y][1] = arr.get(i + 1);
                                y++;
                            }

                            Excel_Azmon_be_Azmon excelAzmonBeAzmon = new Excel_Azmon_be_Azmon(objects,button.getText());

                        }
                    });
                }
            }

            }
         catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
