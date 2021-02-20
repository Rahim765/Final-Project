package Gui.Qustions;

import javax.swing.*;
import java.io.Serializable;

public abstract class Soal implements Serializable {
    public JTextArea soal = new JTextArea();



    public abstract void soal(JLabel label);
    public abstract void action();
}
