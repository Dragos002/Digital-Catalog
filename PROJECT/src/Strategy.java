import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public interface Strategy {
    public Student BestScore(ArrayList<Grade> g);
}

class BestPartialScore implements Strategy{


    @Override
    public Student BestScore(ArrayList<Grade> g) {
        Student student = null;
        Double max = (double) 0;
        for(Grade grade : g)
        {
            if (grade.getPartialScore() > max)
            {
                max = grade.getPartialScore();

            }

        }
        for (Grade grade : g)
            if (Objects.equals(max, grade.getPartialScore()))
                student = grade.getStudent();
        return student;
    }
}

class BestExamScore implements Strategy{


    @Override
    public Student BestScore(ArrayList<Grade> g) {
        Student student = null;
        Double max = (double) 0;
        for(Grade grade : g)
        {
            if (grade.getExamScore() > max)
            {
                max = grade.getExamScore();
            }

        }
        for (Grade grade : g)
        {
            if(Objects.equals(max, grade.getExamScore()))
                student = grade.getStudent();
        }
        return student;
    }
}

class BestTotalScore implements Strategy{
    @Override
    public Student BestScore(ArrayList<Grade> g) {
        Student student = null;
        Double max = (double) 0;
        for(Grade grade : g)
        {
            if (grade.getTotal() > max)
            {
                max = grade.getTotal();
            }
        }
        for (Grade grade : g)
        {
            if(Objects.equals(max, grade.getTotal()))
                student = grade.getStudent();
        }
        return student;
    }


}



