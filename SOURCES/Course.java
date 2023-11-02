import java.util.*;

public abstract class Course implements Strategy{
    String name;
    Teacher teacher;
    Strategy strategy ;
    HashSet<Assistant> assistants;
    ArrayList<Grade> grades;
    HashMap<String,Group> dictionary;

    Snapshot snapshot = new Snapshot();
    int pc;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setAssistants(HashSet<Assistant> assistants) {
        this.assistants = assistants;
    }

    public Set<Assistant> getAssistants() {
        return assistants;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public HashMap<String, Group> getDictionary() {
        return dictionary;
    }

    public void setDictionary(HashMap<String, Group> dictionary) {
        this.dictionary = dictionary;
    }

    public void addAssistant(String ID, Assistant assistant){
        Group g = dictionary.get(ID);
        g.setAssistant(assistant);
        assistants.add(assistant);
    }
    public void addStudent(String ID, Student student){
        Group g = dictionary.get(ID);
        g.add(student);

    }
    public void addGroup(Group group){
        dictionary.put(group.getID(),group);
    }
    public void addGroup(String ID, Assistant assistant){
        Group g = new Group(ID,assistant);
        if (g.getID().equals(ID))
            dictionary.put(g.getID(),g);
    }
    public void addGroup(String ID, Assistant assistant, Comparator<Student> comp){
        Group g = new Group(ID,assistant,comp);
        dictionary.put(g.getID(),g);
    }
    public Grade getGrade(Student student){
        Grade grade = new Grade();
        for(int i=0;i<grades.size();i++){
            if (grades.get(i).getStudent().equals(student))
                    grade = grades.get(i);}
        return grade;
    }
    public void addGrade(Grade grade){

        grades.add(grade);
    }
    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> students = new ArrayList<>();
        for (String i : dictionary.keySet()){
            students.addAll(dictionary.get(i));}
        return students;
    }
    public HashMap<Student, Grade> getAllStudentGrades(){
        HashMap<Student, Grade> h = new HashMap<>();
        for(int i=0;i<grades.size();i++)
            h.put(grades.get(i).getStudent(),grades.get(i));
        return h;
    }
    public abstract ArrayList<Student> getGraduatedStudents();

    public String toString(){
        return getName();
    }

   static abstract class CourseBuilder{
        String name;
        Teacher teacher;
        Strategy strategy ;
        HashSet<Assistant> assistants;
        ArrayList<Grade> grades;
        HashMap<String,Group> dictionary;
        int pc;
        public CourseBuilder(String name, Teacher teacher){
            this.name = name;
            this.teacher = teacher;
        }
        public CourseBuilder assistants(HashSet<Assistant> assistants){
            this.assistants = assistants;
            return this;
        }
        public CourseBuilder grades (ArrayList<Grade> grades){
            this.grades = grades;
            return this;
        }
        public CourseBuilder strategy(Strategy strategy){
            this.strategy = strategy;
            return this;
        }
        public CourseBuilder dictionary(HashMap<String,Group> dictionary){
            this.dictionary = dictionary;
            return this;
        }
       abstract public Course build();
    }
    public Student getBestStudent(){
        Student s =strategy.BestScore(grades);
        return s;
    };

    private class Snapshot{
       private ArrayList<Grade> savedgrades ;

        private Snapshot() {

            this.savedgrades = new ArrayList<>();
        }

        public ArrayList<Grade> getSavedGrades() {
            return savedgrades;
        }
    }
    public void makeBackup() throws CloneNotSupportedException {
            snapshot.getSavedGrades().clear();
        for (Grade grade : getGrades()) {
            Grade gradeback = (Grade) grade.clone();
            snapshot.getSavedGrades().add(gradeback);

        }
    }
    public void undo(){
        grades = snapshot.getSavedGrades();
    }
}

class Catalog implements Subject{
    List<Course> courses;
    List<Observer> observers;

    private static Catalog single_instance = null;
    private Catalog(){
        courses = new LinkedList<>();
        observers = new LinkedList<>();
    }
    public static Catalog getInstance(){
        if (single_instance == null)
            single_instance = new Catalog();
        return  single_instance;
    }

    public void addCourse(Course course){
        if(!courses.contains(course))
            courses.add(course);
    }

    public void removeCourse(Course course){

        courses.remove(course);
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Grade grade) {
       Notification notification = new Notification();
       notification.grade = grade;
        for(Observer observer : observers)
        {

            if (grade.getStudent().getParent().equals(observer))
                    observer.update(notification);
        }
    }
}

class PartialCourse extends Course{

    @Override
    public ArrayList<Student> getGraduatedStudents() {
        ArrayList<Student> s = new ArrayList<>();
        for(Grade grade: getGrades())
            if ( grade.getTotal() >5)
                s.add(grade.getStudent());
        return s;
    }
    private PartialCourse(PartialCourseBuilder builder){
        this.name = builder.name;
        this.teacher = builder.teacher;
        this.assistants = builder.assistants;
        this.grades = builder.grades;
        this.dictionary = builder.dictionary;
    }

    @Override
    public Student BestScore(ArrayList<Grade> g) {
        Student s =strategy.BestScore(grades);
        return s;
    }

    class PartialCourseBuilder extends CourseBuilder{

        public PartialCourseBuilder(String name, Teacher teacher) {
            super(name, teacher);
        }
        public PartialCourseBuilder assistants(HashSet<Assistant> assistants){
            this.assistants = assistants;
            return this;
        }
        public PartialCourseBuilder grades (ArrayList<Grade> grades){
            this.grades = grades;
            return this;
        }
        public PartialCourseBuilder dictionary(HashMap<String,Group> dictionary){
            this.dictionary = dictionary;
            return this;
        }
        @Override
        public Course build() {
            return new PartialCourse(this);
        }
    }
}

class FullCourse extends Course{


    private FullCourse(FullCourseBuilder builder){
        this.name = builder.name;
        this.teacher = builder.teacher;
        this.assistants = builder.assistants;
        this.grades = builder.grades;
        this.dictionary = builder.dictionary;
    }

    @Override
    public ArrayList<Student> getGraduatedStudents() {

        ArrayList<Student> s = new ArrayList<>();
        for(Grade grade : getGrades())
            if ( grade.getPartialScore() >=3 && grade.getExamScore() >=2 )
                s.add(grade.getStudent());
        return s;
    }

    @Override
    public Student BestScore(ArrayList<Grade> g) {
        Student s =strategy.BestScore(grades);
        return s;
    }


    static class FullCourseBuilder extends CourseBuilder{

        public FullCourseBuilder(String name, Teacher teacher) {
            super(name, teacher);
        }

        public FullCourseBuilder assistants(HashSet<Assistant> assistants){
            this.assistants = assistants;
            return this;
        }
        public FullCourseBuilder grades (ArrayList<Grade> grades){
            this.grades = grades;
            return this;
        }
        public FullCourseBuilder dictionary(HashMap<String,Group> dictionary){
            this.dictionary = dictionary;
            return this;
        }

        @Override
        public Course build() {
            return new FullCourse(this);
        }

    }
}
