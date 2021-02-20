package Gui.Qustions;

import javax.swing.*;
import java.awt.*;

public class Soal_TrueFalse extends Soal{
    public  JCheckBox True = new JCheckBox("True");
    public  JCheckBox False = new JCheckBox("False");
    public JTextField textField;
    ButtonGroup buttonGroup = new ButtonGroup();
    public Soal_TrueFalse(JLabel label,JCheckBox tashih)
    {
        soal(label);
        if (tashih.isSelected())
        {
            textField = new JTextField();
            textField.setBounds(950,400,60,40);
            label.add(textField);

        }
    }

    @Override
    public void soal(JLabel label) {


        soal.setBounds(580,150,600,150);
        soal.setBackground(Color.yellow);
        soal.setBackground(Color.orange);

        True.setBounds(1080,350,100,40);
        False.setBounds(900,350,100,40);

        buttonGroup.add(True);
        buttonGroup.add(False);

        True.setBackground(Color.orange);
        False.setBackground(Color.orange);

        label.add(soal);
        label.add(True);
        label.add(False);
    }

    @Override
    public void action() {

    }
}
