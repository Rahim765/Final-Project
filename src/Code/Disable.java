package Code;

import Gui.Qustions.Soal_Explain;
import Gui.Qustions.Soal_Testi;
import Gui.Qustions.Soal_TrueFalse;
import Gui.Tarahi_Azmon;

public class Disable {
    public Disable(Tarahi_Azmon tarahi_azmon)
    {
        disable(tarahi_azmon);
    }
    public void disable(Tarahi_Azmon tarahi_azmon)
    {
        for (int i = 0; i <tarahi_azmon.soalat.length ; i++) {
            if (tarahi_azmon.soalat[i] instanceof Soal_Explain)
            {
                Soal_Explain s = (Soal_Explain) tarahi_azmon.soalat[i];
                s.javab.setEditable(false);
                s.upload.setEnabled(false);
            }
            else if (tarahi_azmon.soalat[i] instanceof Soal_TrueFalse)
            {
                Soal_TrueFalse s  = (Soal_TrueFalse) tarahi_azmon.soalat[i];
                s.False.setEnabled(false);
                s.True.setEnabled(false);
            }
            else if (tarahi_azmon.soalat[i] instanceof Soal_Testi)
            {
                Soal_Testi s = (Soal_Testi) tarahi_azmon.soalat[i];
                for (int j = 0; j <4 ; j++) {
                    s.jTextFieldes[j].setEnabled(false);
                    s.jCheckBoxes[j].setEnabled(false);
                }

            }
        }
    }
}
