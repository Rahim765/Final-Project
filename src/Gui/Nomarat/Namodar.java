package Gui.Nomarat;

import Gui.Tarahi_Azmon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Namodar {
    JFrame frame;
    double x=0;
    double sum=0;

    public Namodar(String creator, JFrame jframe) {

        namodar(creator);

    }

    public void namodar(String creator) {

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


                            for (int i = 0 ; i < tarahiAzmon.attends.size() ; i++) {
                                File file = new File(line + "/" + tarahiAzmon.attends.get(i) + ".txt");
                                try {
                                    FileInputStream fileOutputStream2 = new FileInputStream(file);
                                    ObjectInputStream objectOutputStream2 = new ObjectInputStream(fileOutputStream2);
                                    Tarahi_Azmon tarahi_azmon2 = (Tarahi_Azmon) objectOutputStream2.readObject();


                                    sum += Integer.parseInt(tarahi_azmon2.nomrehjam.getText());


                                } catch (FileNotFoundException fileNotFoundException) {
                                    fileNotFoundException.printStackTrace();
                                } catch (IOException ioException) {
                                    ioException.printStackTrace();
                                } catch (ClassNotFoundException classNotFoundException) {
                                    classNotFoundException.printStackTrace();
                                }


                                x++;
                            }

                }
                defaultCategoryDataset.setValue(sum/x,"Marks",line);
                System.out.println(line);
                System.out.println(sum);
                sum=0;
                x=0;
            }
            JFreeChart jFreeChart = ChartFactory.createBarChart("Azmon records","Azmon names",
                    "Azmon marks",defaultCategoryDataset, PlotOrientation.VERTICAL,true,true,false);

            CategoryPlot plot = jFreeChart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.black);

            ChartFrame chartFrame = new ChartFrame("Azmon records",jFreeChart,true);
            chartFrame.setVisible(true);
            chartFrame.setSize(500,400);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}