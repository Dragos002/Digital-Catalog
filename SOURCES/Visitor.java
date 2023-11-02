import java.util.HashMap;

public interface Visitor {
    void visits(Assistant assistant);
    void visits(Teacher teacher);
}

interface Element {
    void accept(Visitor visitor);
}

class ScoreVisitor implements Visitor{
    HashMap<Assistant,Tuple<String,String,Double>> partialScore = new HashMap<>();
    HashMap<Teacher,Tuple<String,String,Double>> examScores= new HashMap<>();
    Catalog catalog = Catalog.getInstance();
    @Override
    public void visits(Assistant assistant) {
        Tuple tuple = new Tuple<String,String,Double>();
        for (Course course : catalog.courses)
        {
            if(course.getAssistants().contains(assistant))
            {
                for (Grade grade : course.getGrades())
                {
                    tuple.grade = grade.getExamScore();
                    tuple.namecourse = course.getName();
                    tuple.student = grade.getStudent();
                    partialScore.put(assistant,tuple);
                    if (course.getAssistants().contains(assistant))
                        catalog.notifyObservers(grade);
                }
            }
        }
    }

    @Override
    public void visits(Teacher teacher) {

        Tuple tuple = new Tuple<String,String,Double>();
        for (Course course : catalog.courses)
        {
            if(course.getTeacher().equals(teacher))
            {
                for (Grade grade : course.getGrades())
                {
                    tuple.grade = grade.getExamScore();
                    tuple.namecourse = course.getName();
                    tuple.student = grade.getStudent();
                    examScores.put(teacher,tuple);
                    if (course.getTeacher().equals(teacher))
                        catalog.notifyObservers(grade);
                }
            }
        }

    }

    private class Tuple<A,C,B>{
        A student;
        C namecourse;
        B grade;
        Tuple(){}
        Tuple(A student, C namecourse, B grade){
            this.student = student;
            this.namecourse = namecourse;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return student + " " + namecourse + " " + grade;
        }
    }
}
