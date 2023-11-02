import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class Cataloggrafic implements ActionListener {
   Catalog catalog;
   JButton studentbutton;
   JButton Teacherbutton;
   JButton parentbutton;
   JPanel previewpagesl;
    Cataloggrafic() throws CloneNotSupportedException {
        new Test();


        //interfata catalog
        JFrame frame = new JFrame("Catalog");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.setMinimumSize(new Dimension(400,400));
         studentbutton = new JButton("Student's page");
         Teacherbutton = new JButton("Teacher's page");
         parentbutton= new JButton("Parent's page");
        studentbutton.addActionListener(this);
        Teacherbutton.addActionListener(this);
        parentbutton.addActionListener(this);
        JPanel catalogoptions = new JPanel();
        catalogoptions.add(studentbutton);
        catalogoptions.add(Teacherbutton);
        catalogoptions.add(parentbutton);
        catalogoptions.setLayout(new GridLayout(3,1));
        frame.add(catalogoptions,BorderLayout.CENTER);
        frame.setVisible(true);
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == studentbutton)
            new StudentPage();
        if (e.getSource() == Teacherbutton)
            new Teacherpage();
        if (e.getSource() == parentbutton)
            new Parentinterface();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        new Cataloggrafic();
    }
}
