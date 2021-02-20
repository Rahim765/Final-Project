package Gui.Qustions;

import com.sun.crypto.provider.JceKeyStore;

import javax.swing.*;
import java.awt.*;

public class Soal_Testi extends Soal{

    int x= 350;
    public JCheckBox[] jCheckBoxes = new JCheckBox[4];
    public JTextField[] jTextFieldes = new JTextField[4];
    public JTextField textField;

    public Soal_Testi(JLabel label,JCheckBox tashih)
    {

        soal(label);
        if (tashih.isSelected())
        {
            textField = new JTextField();
            textField.setBounds(700,450,60,20);
            label.add(textField);
        }
    }


    @Override
    public void soal(JLabel label) {


        soal.setBounds(580,150,600,150);
        soal.setBackground(Color.orange);
        ButtonGroup buttonGroup = new ButtonGroup();

        for (int i = 0; i <4 ; i++) {
            jCheckBoxes[i] = new JCheckBox();
            jCheckBoxes[i].setBounds(1140,x,40,40);
            jCheckBoxes[i].setBackground(Color.orange);
            buttonGroup.add(jCheckBoxes[i]);

            jTextFieldes[i] = new JTextField();
            jTextFieldes[i].setBounds(800,x,280,40);
            jTextFieldes[i].setBackground(Color.orange);
            x+=50;
            label.add(jCheckBoxes[i]);
            label.add(jTextFieldes[i]);
        }

        label.add(soal);

    }

    @Override
    public void action() {

    }
}
