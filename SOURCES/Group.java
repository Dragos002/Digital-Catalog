import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

public class Group extends HashSet<Student> {
   private Assistant assistant;
   private String ID;
   public Group(String ID, Assistant assistant){
       this.ID = ID;
       this.assistant = assistant;
   }

    public Assistant getAssistant() {
        return assistant;
    }

    public String getID() {
        return ID;
    }

    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public boolean equals(Group group){
       return ID.equals(group.ID);
    }

    public Group(String ID, Assistant assistant, Comparator<Student> comp){
        this.ID = ID;
        this.assistant = assistant;
        comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
               return o1.getLastname().compareTo(o2.getLastname());
            }
        };
   }
}
