package Code;

import javax.swing.*;

public class Enabel_Disable {
    public  void disable(JTextField hour ,JTextField hour2,JTextField hour3,JTextField hour4 ,JTextField timeAzmon,
                         JTextArea filepath,JButton addfromfile,JTextField nameazmon, JTextArea student_name ,
                         JTextArea student_lastname,JTextArea student_Id,JButton add,JTextField year,JTextField month,
                         JTextField day,JCheckBox moror,JCheckBox tashih,JCheckBox tartib)
    {
        hour.setEditable(false);
        hour2.setEditable(false);
        hour3.setEditable(false);
        hour4.setEditable(false);
        timeAzmon.setEditable(false);
        filepath.setEditable(false);
        addfromfile.setEnabled(false);
        nameazmon.setEditable(false);
        student_name.setEditable(false);
        student_lastname.setEditable(false);
        student_Id.setEditable(false);
        add.setEnabled(false);
        year.setEditable(false);
        month.setEditable(false);
        day.setEditable(false);
        moror.setEnabled(false);
        tashih.setEnabled(false);
        tartib.setEnabled(false);
    }
}
