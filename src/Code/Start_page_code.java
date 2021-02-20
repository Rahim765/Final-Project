package Code;

import Gui.Student_Login;
import Gui.Teacher_Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start_page_code {
    public void student(JButton student, JFrame frame)
    {
        student.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Student_Login s= new Student_Login(frame);


            }
        });
    }
    public void teacher(JButton teacher, JFrame frame)
    {
        teacher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Teacher_Login t= new Teacher_Login(frame);
            }
        });
    }
}
