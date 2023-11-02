import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.HashSet;
import java.util.Vector;

public class Parentinterface implements ListSelectionListener {
    Catalog catalog;
    Vector<Observer> parents;
    JFrame frame;

    public Parentinterface() {
        catalog = Catalog.getInstance();
        frame = new JFrame("Parent's page");
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 500));
        frame.setLayout(new BorderLayout());
        JList<Observer> parentslist;
        parents = new Vector<>();
        for (Observer parent : catalog.observers) {
            parents.add(parent);
        }
        parentslist = new JList<>(parents);
        JScrollPane scrollPane = new JScrollPane(parentslist);
        scrollPane.setPreferredSize(new Dimension(100, 500));
        parentslist.addListSelectionListener(this);
        frame.add(scrollPane, BorderLayout.WEST);
        frame.setVisible(true);
        frame.pack();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        new Test();
        new Parentinterface();
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList list = (JList) e.getSource();
        if (e.getValueIsAdjusting()) {
            Vector<Notification> parentnotific = new Vector<>();
            Notification notification = new Notification();
            for (Course course : catalog.courses)
                for (Student student : course.getAllStudents())
                {
                    if (student.getParent().equals(list.getSelectedValue())) {
                        catalog.notifyObservers(course.getGrade(student));
                        notification = student.getParent().getNotification();
                        parentnotific.add(student.getParent().getNotification());
                    }
                     }
            JOptionPane.showMessageDialog(frame,parentnotific);


        }
    }
}
