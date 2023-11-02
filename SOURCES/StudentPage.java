import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class StudentPage implements ListSelectionListener {

    HashSet<Student> allstudents;
    Catalog catalog = Catalog.getInstance();
    Vector<JButton> atendedcourses;
    JPanel panouinfocurs = new JPanel();
    Vector<JButton> atended= new Vector<>();
    JTextField profesortitular = new JTextField(); // profesorul titular al cursului
    JTextField courseassistans = new JTextField(); // asistentii cursului
    JTextField studentgrades = new JTextField(); // notele studentului
    JPanel coursepanel = new JPanel(); // panoul ce contine cursurile la care participa studentul
    JPanel coursespanel;
    JFrame frame = new JFrame("Student's Page");
    public StudentPage(){



        // interfata grafica

        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setMinimumSize(new Dimension(600,500));
        frame.setSize(800,800);
        //lista cu studentii
         allstudents = new HashSet<>();
        for(Course course:catalog.courses)
        {
            HashSet<Student> s = new HashSet<>();
            s.addAll(course.getAllStudents());
            for(Student student : s)
                allstudents.add(student);
        }
        Vector<Student> allstudent = new Vector<>();
        for (Student student : allstudents)
            allstudent.add(student);
        JList<Student> studentJList = new JList<>(allstudent);
        JScrollPane scrollPane = new JScrollPane(studentJList);
        scrollPane.setPreferredSize(new Dimension(100,500));
        frame.add(scrollPane,BorderLayout.LINE_START);

        // cursurile la care este inscris studentul
        atended = new Vector<>();
        studentJList.addListSelectionListener(this);
        frame.setVisible(true);

        frame.pack();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        new Test();
        new StudentPage();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList) e.getSource();
        if(e.getValueIsAdjusting()){
            atendedcourses = new Vector<>();
            for (Course course : catalog.courses)
            {
                if (course.getAllStudents().contains(list.getSelectedValue()))
                {

                    atendedcourses.add(new JButton(course.getName()));

                }

            }
            coursepanel.removeAll();
            coursepanel.revalidate();
            coursepanel.repaint();

            profesortitular.setEditable(false);
            courseassistans.setEditable(false);
            studentgrades.setEditable(false);
            for (JButton button : atendedcourses) {
                coursepanel.add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (Course course : catalog.courses){
                            if (e.getSource() == button)
                            {
                                if (button.getText().equals(course.getName()))
                                {
                                    profesortitular.setText("Teacher :" + course.getTeacher());
                                    courseassistans.setText("Asisants : " + course.getAssistants());
                                    studentgrades.setText("Grades : " + course.getGrade((Student) list.getSelectedValue()));
                                }
                            }
                        }
                    }
                });
            }

            coursepanel.setLayout(new GridLayout(atendedcourses.size(),1));

            panouinfocurs.setLayout(new GridLayout(3,1));
            panouinfocurs.add(profesortitular);
            panouinfocurs.add(courseassistans);
            panouinfocurs.add(studentgrades);
            frame.add(panouinfocurs,BorderLayout.CENTER);
            frame.add(coursepanel,BorderLayout.AFTER_LAST_LINE);
            frame.setVisible(true);

        }

    }
}