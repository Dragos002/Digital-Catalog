public interface Observer {
    void update(Notification notification);
}
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Grade grade);
}

class Notification{
    Grade grade;


    public String toString(){
        return grade.getStudent() + " " + grade.getTotal() + " " + grade.getCourse();
    }
}