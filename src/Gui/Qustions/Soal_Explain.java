package Gui.Qustions;

import sun.security.krb5.internal.crypto.Des;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Soal_Explain extends Soal{
   public JTextArea javab = new JTextArea();
   public JButton upload = new JButton("Upload");
   public JButton image = new JButton();

    public Soal_Explain (JLabel label)
    {
        soal(label);
    }

    @Override
    public void soal(JLabel label) {

        soal.setBounds(580,150,600,150);
        soal.setBackground(Color.orange);

        javab.setBounds(680,350,500,200);
        javab.setBackground(Color.orange);

        upload.setBounds(580,350,90,40);
        upload.setBackground(Color.orange);


        image.setBounds(100,400,400,30);
        image.setOpaque(true);
        image.setBackground(Color.orange);






        label.add(soal);
        label.add(javab);
        label.add(upload);
        label.add(image);
    }

    @Override
    public void action() {
          upload.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "JPG Images", "jpg");
                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    image.setText(chooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

          image.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File(image.getText());
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.open(file);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });

    }
}
