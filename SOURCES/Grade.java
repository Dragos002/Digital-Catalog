public class Grade implements  Comparable, Cloneable{

    private Double partialScore, examScore;
    private Student student;
    private String course;

    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public Student getStudent(){
        return student;
    }
    public void setStudent(Student student){
        this.student = student;
    }
    public Double getPartialScore(){
        return partialScore;
    }
    public  void  setPartialScore(Double partialScore){
        this.partialScore = partialScore;
    }
    public Double getExamScore(){
        return examScore;
    }
    public void setExamScore(Double examScore){
        this.examScore = examScore;
    }

    public Double getTotal(){
        return partialScore + examScore;
    }

    @Override
    public int compareTo(Object o) {
        Grade o1 = (Grade) o;
        if(getTotal() > o1.getTotal())
                return 1;
        if(getTotal() == o1.getTotal())
                return 0;
        else
                return -1;

    }
    public String toString(){
        return partialScore + " " + examScore;
    }

    public Object clone() throws CloneNotSupportedException {
        {
            return super.clone();
        }
    }
}

