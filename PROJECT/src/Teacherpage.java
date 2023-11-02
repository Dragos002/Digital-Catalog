import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

public class Teacherpage implements ListSelectionListener {
    Catalog catalog;
    JFrame teacherframe;
    HashSet<Teacher> teachers;
    JPanel panel = new JPanel();
    JButton validate = new JButton("Validate");
    JPanel gradespanel = new JPanel();
    JTextField gradestextfield = new JTextField();

   public Teacherpage(){
       catalog = Catalog.getInstance();

       //interfata teacher
        teacherframe = new JFrame("Teacher's Page");
       teacherframe.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
       teacherframe.setLayout(new BorderLayout());
       teacherframe.setPreferredSize(new Dimension(800,500));
       teachers = new HashSet<>();
       Vector<Teacher> allteachers = new Vector<>();
       for(Course course : catalog.courses )
       {
           teachers.add(course.getTeacher());
       }
       for (Teacher teacher : teachers)
           allteachers.add(teacher);
       JList<Teacher> teacherJList = new JList<>(allteachers); //lista cu toti profesorii
       JScrollPane teacherscrollpane = new JScrollPane(teacherJList);

       teacherJList.addListSelectionListener(this);
       teacherframe.add(teacherscrollpane,BorderLayout.WEST);


       teacherframe.setVisible(true);
       teacherframe.pack();

   }

    public static void main(String[] args) throws CloneNotSupportedException {
       new Test();
       new Teacherpage();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList) e.getSource();

        if(e.getValueIsAdjusting())
        {
            Vector<JButton> courselist = new Vector<>();

            for (Course course : catalog.courses)
            {
                if(course.getTeacher().equals(list.getSelectedValue()))
                {
                    courselist.add(new JButton(course.getName()));
                }
            }

            panel.removeAll();
            panel.revalidate();
            panel.repaint();

            for (JButton button : courselist)
            {panel.add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == button){Vector<String> grades = new Vector<>();
                            for (Course course : catalog.courses)
                            {
                                if (button.getText().equals(course.getName()))
                                {
                                    grades.add(String.valueOf(course.getGrades()));
                                }
                            }

                            validate.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (e.getSource() == validate)
                                    {
                                        gradestextfield.setForeground(Color.green);

                                        JOptionPane.showMessageDialog(teacherframe,"Grades validated");
                                    }
                                }
                            });
                            gradestextfield.setForeground(Color.BLACK);
                     gradestextfield.setText(String.valueOf(grades));
                     gradestextfield.setEditable(false);
                        gradespanel.add(gradestextfield);
                        gradespanel.add(validate);
                        teacherframe.add(gradespanel,BorderLayout.CENTER);
                        teacherframe.revalidate();
                        }
                    }
                });

            }


            panel.setLayout(new GridLayout(courselist.size(),1));
            teacherframe.add(panel,BorderLayout.AFTER_LAST_LINE);
            teacherframe.setVisible(true);

        }


    }
}
