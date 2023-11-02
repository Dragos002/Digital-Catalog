
class UserFactory{
    public User getUser(String firstname, String lastname, String type){
        if (type.equals("Student"))
            return new Student(firstname,lastname);
        if( type.equals("Parent"))
            return new Parent(firstname,lastname);
        if( type.equals("Assistant"))
            return new Assistant(firstname,lastname);
        if(type.equals("Teacher"))
            return new Teacher(firstname,lastname);
        throw new IllegalArgumentException("Unknown user: "+ type);
    }
}
public abstract class User {
    private String firstname, lastname;

    public String getLastname() {
        return lastname;
    }

    public User(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String toString(){
        return firstname + " " + lastname;
    }
}

class Student extends User{
    private Parent mother, father;


    public Student(String firstname, String lastname) {
        super(firstname, lastname);
    }

    public void setMother(Parent mother){
        this.mother = mother;
    }
    public void setFather(Parent father){
        this.father = father;
    }

    public Parent getParent() {
        if (father==null)
            return mother;
        else
            return father;
    }
}

class Parent extends User implements Observer{

    private Notification notification = new Notification();
    public Parent(String firstname, String lastname) {
        super(firstname, lastname);
    }

    @Override
    public void update(Notification notification) {

        System.out.println(this + " notificare noua : " + notification);
        addNotification(notification);
    }
    public void addNotification(Notification notification){
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }
}

class Assistant extends User implements Element{

    public Assistant(String firstname, String lastname) {
        super(firstname, lastname);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visits(this);
    }
}

class Teacher extends User implements Element{

    public Teacher(String firstname, String lastname) {
        super(firstname, lastname);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visits(this);
    }
}
