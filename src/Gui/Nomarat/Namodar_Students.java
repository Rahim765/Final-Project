package Gui.Nomarat;

import Gui.Tarahi_Azmon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Namodar_Students {
    int sum=0;
    int x=0;
    JFrame jFrame;
    JLabel label = new JLabel();
    JButton back = new JButton();
    public Namodar_Students(String creator,JFrame frame)
    {
        frame.setVisible(false);
        jFrame = new JFrame();
        jFrame.setExtendedState(jFrame.MAXIMIZED_BOTH);

        label.setBounds(0,0,1400,720);
        ImageIcon imageIcon = new ImageIcon("Images/namodar34.jpg");
        label.setIcon(imageIcon);
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
        label.add(back);

        jFrame.add(label);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
        namodar_student(creator);
    }
    public void namodar_student(String creator)
    {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
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
                    button.setBounds(1280,x,100,40);
                    x+=40;
                    button.setBackground(Color.orange);
                    jFrame.add(button);
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            for (int i = 0 ; i < tarahiAzmon.attends.size() ; i++) {
                                File file = new File(button.getText() + "/" + tarahiAzmon.attends.get(i) + ".txt");
                                try {
                                    FileInputStream fileOutputStream2 = new FileInputStream(file);
                                    ObjectInputStream objectOutputStream2 = new ObjectInputStream(fileOutputStream2);
                                    Tarahi_Azmon tarahi_azmon2 = (Tarahi_Azmon) objectOutputStream2.readObject();


                                    sum += Integer.parseInt(tarahi_azmon2.nomrehjam.getText());

                                    System.out.println(sum);
                                    defaultCategoryDataset.setValue(sum,"Marks",tarahi_azmon2.attends.get(i));

                                } catch (FileNotFoundException fileNotFoundException) {
                                    fileNotFoundException.printStackTrace();
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                } catch (ClassNotFoundException classNotFoundException) {
                                    classNotFoundException.printStackTrace();
                                }

                                sum=0;
                            }
                            JFreeChart jFreeChart = ChartFactory.createBarChart("Student records","Student names",
                                    "Azmon marks",defaultCategoryDataset, PlotOrientation.VERTICAL,true,true,false);

                            CategoryPlot plot = jFreeChart.getCategoryPlot();
                            plot.setRangeGridlinePaint(Color.black);

                            ChartFrame chartFrame = new ChartFrame("Azmon records",jFreeChart,true);
                            chartFrame.setVisible(true);
                            chartFrame.setSize(500,400);
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
    }
}
