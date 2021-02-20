package Code;

import Gui.Qustions.Soal_Testi;
import Gui.Qustions.Soal_TrueFalse;
import Gui.Tarahi_Azmon;

public class Tashih {
    public Tashih(Tarahi_Azmon azmon)
    {
        tashih(azmon);
    }
    public void tashih (Tarahi_Azmon tarahi_azmon)
    {
        if (tarahi_azmon.autoscore.isSelected())
        {
            System.out.println("Salam yes ok");

            for (int i = 0; i <tarahi_azmon.tedadsoal-1 ; i++) {
                System.out.println(tarahi_azmon.tedadsoal-1);
                if (tarahi_azmon.soalat[i] instanceof Soal_Testi)
                {
                    System.out.println("hello");
                    Soal_Testi s = (Soal_Testi) tarahi_azmon.soalat[i];
                    int x = Integer.parseInt(s.textField.getText());

                    if (s.jCheckBoxes[x-1].isSelected())
                    {
                        System.out.println("Salam23");
                        tarahi_azmon.nomarart[i].setText("1");
                    }
                    else {
                        System.out.println("salam ajn");
                        tarahi_azmon.nomarart[i].setText("0");
                    }
                    s.textField.setVisible(true);
                }
                else if (tarahi_azmon.soalat[i] instanceof Soal_TrueFalse) {
                    Soal_TrueFalse s = (Soal_TrueFalse) tarahi_azmon.soalat[i];
                    if (s.True.isSelected()) {
                        System.out.println("hi");
                        if (s.textField.getText().equals(s.True.getText())) {
                            tarahi_azmon.nomarart[i].setText("1");
                            System.out.println("Hi 2");
                        } else {
                            tarahi_azmon.nomarart[i].setText("0");
                            System.out.println("hi 3");
                        }
                    }
                    else if (s.False.isSelected())
                    {
                        System.out.println(s.False.getText());
                        System.out.println("ok");
                        if (s.textField.getText().equals(s.False.getText())) {
                            tarahi_azmon.nomarart[i].setText("1");
                            System.out.println("ok 2");
                        } else {
                            tarahi_azmon.nomarart[i].setText("0");
                            System.out.println("Ok 5");
                        }
                    }
                    s.textField.setVisible(true);
                }
            }
        }
        int sum =0;
        for (int i = 0; i <tarahi_azmon.tedadsoal-1 ; i++) {
            System.out.println(tarahi_azmon.nomarart[i].getText());
            sum+=Integer.parseInt(tarahi_azmon.nomarart[i].getText());
        }
        tarahi_azmon.nomrehjam.setText(String.valueOf(sum));
        System.out.println(sum);
    }
}
