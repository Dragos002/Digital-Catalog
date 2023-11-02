import java.util.*;

public class Test {

    public Test() throws CloneNotSupportedException {
        Catalog catalog=Catalog.getInstance();
        ScoreVisitor scoreVisitor = new ScoreVisitor();
            catalog = Catalog.getInstance();
            // teachers
            User teacherPOO = new UserFactory().getUser("Ion", "Serban", "Teacher");
            User teacherSO = new UserFactory().getUser("Alin","Florin","Teacher");
            User teacherAA = new UserFactory().getUser("Mihai","Bogdan","Teacher");
            User teacherFIZICA = new UserFactory().getUser("Ionescu","Dan","Teacher");

            // assistants
            User assistant1 = new UserFactory().getUser("Jan","Alex","Assistant");
            User assistant2 = new UserFactory().getUser("Alin","Adrian","Assistant");
            User assistant3 = new UserFactory().getUser("Bucur","Adi","Assistant");
            User assistant4 = new UserFactory().getUser("Cornel","Banu","Assistant");
            User assistant5 = new UserFactory().getUser("Dan","Flavius","Assistant");
            User assistant6 = new UserFactory().getUser("Eusebiu","Darius","Assistant");
            User assistant7 = new UserFactory().getUser("Florin","Cezar","Assistant");
            User assistant8 = new UserFactory().getUser("Geauzar","Tudor","Assistant");
            User assistant9 = new UserFactory().getUser("Hristu","Costel","Assistant");
            User assistant10 = new UserFactory().getUser("Ian","Sebastian","Assistant");
        System.out.println("Testare clasa user ( si subclase)  :  " + teacherFIZICA + "(teacher) " + assistant2 + "(assistant)");
            // groups of assistans;
            HashSet<Assistant> assistantsPOO = new HashSet<>();
            HashSet<Assistant> assistantsSO = new HashSet<>();
            HashSet<Assistant> assistantsAA = new HashSet<>();
            HashSet<Assistant> assistantsFIZICA = new HashSet<>();
            HashSet<Assistant> assistantsDEEA = new HashSet<>();

            assistantsPOO.add((Assistant) assistant1);
            assistantsPOO.add((Assistant) assistant2);

            assistantsAA.add((Assistant) assistant3);
            assistantsAA.add((Assistant) assistant4);

            assistantsSO.add((Assistant) assistant5);
            assistantsSO.add((Assistant) assistant6);

            assistantsFIZICA.add((Assistant) assistant7);
            assistantsFIZICA.add((Assistant) assistant8);

            assistantsDEEA.add((Assistant) assistant9);
            assistantsDEEA.add((Assistant) assistant10);

            // students
            User student1 = new UserFactory().getUser("Ionescu","Negoi","Student");
            User student2 = new UserFactory().getUser("Popescu","Nev","Student");
            User student3 = new UserFactory().getUser("Steluta","Ran","Student");
            User student4 = new UserFactory().getUser("Bogdan","Zen","Student");
            User student5 = new UserFactory().getUser("Selaru","Ren","Student");
            User student6 = new UserFactory().getUser("Negoi","Gal","Student");
            User student7 = new UserFactory().getUser("Giuglea","Alg","Student");
            User student8 = new UserFactory().getUser("Oprea","Zals","Student");
            User student9 = new UserFactory().getUser("Stel","Cam","Student");
            User student10 = new UserFactory().getUser("Macovei","Ion","Student");
            User student11 = new UserFactory().getUser("Murc","Pop","Student");
            System.out.println("\nTestare userfactory, studentul " + student2 + " a fost declarat ca user si folosind userfactory este de tipul : "+ student2.getClass());
            // groups
            Group group1 = new Group("1",(Assistant) assistant1);
            Group group2 = new Group("2",(Assistant) assistant2);
            Group group3 = new Group("3",(Assistant) assistant3);
            Group group4 = new Group("4",(Assistant) assistant4);
            Group group5 = new Group("5",(Assistant) assistant5);
            Group group6 = new Group("6",(Assistant) assistant6);
            Group group7 = new Group("7",(Assistant) assistant7);
            Group group8 = new Group("8",(Assistant) assistant8);
            Group group9 = new Group("9",(Assistant) assistant9);
            Group group10 = new Group("10",(Assistant) assistant10);
            System.out.println("\nAfisare asistent grupa 1 : " + group1.getAssistant() + " + ID-ul grupei : " + group1.getID());
            // grades
            ArrayList<Grade> gradesPOO = new ArrayList<>();
            ArrayList<Grade> gradesAA = new ArrayList<>();
            ArrayList<Grade> gradesSO = new ArrayList<>();
            ArrayList<Grade> gradesFIZICA = new ArrayList<>();
            ArrayList<Grade> gradesDEEA = new ArrayList<>();
            // dictionarys
            HashMap<String,Group> dictionaryPOO = new HashMap<>();
            HashMap<String,Group> dictionaryAA = new HashMap<>();
            HashMap<String,Group> dictionaryFIZICA = new HashMap<>();
            HashMap<String,Group> dictionarySO = new HashMap<>();
            HashMap<String,Group> dictionaryDEEA = new HashMap<>();
            // courses
            Course POO = new FullCourse.FullCourseBuilder("POO",(Teacher) teacherPOO).assistants(assistantsPOO).grades(gradesPOO).dictionary(dictionaryPOO).build();
            Course SO = new FullCourse.FullCourseBuilder("SO",(Teacher) teacherSO).assistants(assistantsSO).grades(gradesSO).dictionary(dictionarySO).build();
            Course AA = new FullCourse.FullCourseBuilder("AA",(Teacher) teacherAA).assistants(assistantsAA).grades(gradesAA).dictionary(dictionaryAA).build();
            Course FIZICA = new FullCourse.FullCourseBuilder("FIZICA",(Teacher) teacherFIZICA).assistants(assistantsFIZICA).grades(gradesFIZICA).dictionary(dictionaryFIZICA).build();
            Course DEEA = new FullCourse.FullCourseBuilder("DEEA",(Teacher) teacherFIZICA).assistants(assistantsDEEA).grades(gradesDEEA).dictionary(dictionaryDEEA).build();
            System.out.println("\nCourse-ul DEEA a fost creat folosind FullCourseBuilder : " + DEEA + "--->" + DEEA.getClass());
            //adaugare studenti in grupe
            group1.add((Student) student1);
            group1.add((Student) student2);
            group1.add((Student) student3);
            group1.add((Student) student4);
            group1.add((Student) student5);
            group1.add((Student) student11);

            group2.add((Student) student6);
            group2.add((Student) student7);
            group2.add((Student) student8);
            group2.add((Student) student9);
            group2.add((Student) student10);

            group3.add((Student) student1);
            group3.add((Student) student2);
            group3.add((Student) student3);
            group3.add((Student) student4);
            group3.add((Student) student5);

            group4.add((Student) student6);
            group4.add((Student) student7);
            group4.add((Student) student8);
            group4.add((Student) student9);
            group4.add((Student) student10);

            group5.add((Student) student1);
            group5.add((Student) student2);
            group5.add((Student) student3);
            group5.add((Student) student4);
            group5.add((Student) student5);

            group6.add((Student) student6);
            group6.add((Student) student7);
            group6.add((Student) student8);
            group6.add((Student) student9);
            group6.add((Student) student10);

            group7.add((Student) student1);
            group7.add((Student) student2);
            group7.add((Student) student3);
            group7.add((Student) student4);
            group7.add((Student) student5);

            group8.add((Student) student6);
            group8.add((Student) student7);
            group8.add((Student) student8);
            group8.add((Student) student9);
            group8.add((Student) student10);

            group9.add((Student) student1);
            group9.add((Student) student2);
            group9.add((Student) student3);
            group9.add((Student) student4);
            group9.add((Student) student5);

            group10.add((Student) student6);
            group10.add((Student) student7);
            group10.add((Student) student8);
            group10.add((Student) student9);
            group10.add((Student) student10);
            System.out.println("\nAfisare grupa 1 (un TreeSet de studenti ) : "+group1);
            //adaugare grupe in cursuri
            POO.addGroup("1",(Assistant) assistant1);
            POO.addGroup("2",(Assistant) assistant2);

            AA.addGroup("3",(Assistant) assistant3);
            AA.addGroup("4",(Assistant) assistant4);

            SO.addGroup("5",(Assistant) assistant5);
            SO.addGroup("6",(Assistant) assistant6);

            FIZICA.addGroup("7",(Assistant) assistant7);
            FIZICA.addGroup("8",(Assistant) assistant8);

            DEEA.addGroup("9",(Assistant) assistant9);
            DEEA.addGroup("10",(Assistant) assistant10);
            // configurare catalog
            dictionaryPOO.put("1",group1);
            dictionaryPOO.put("2",group2);

            dictionaryAA.put("3",group3);
            dictionaryAA.put("4",group4);

            dictionarySO.put("5",group5);
            dictionarySO.put("6",group6);

            dictionaryFIZICA.put("7",group7);
            dictionaryFIZICA.put("8",group8);

            dictionaryDEEA.put("9",group9);
            dictionaryDEEA.put("10",group10);
            System.out.println("\nAfisare grupele de la cursul DEEA(dictionarul cerut) : "+dictionaryAA);
            //note

            Grade grade = new Grade();
            grade.setExamScore(5.0);
            grade.setPartialScore(2.5);
            grade.setCourse(POO.getName());
            grade.setStudent((Student) student1);
            gradesPOO.add(grade);

        Grade grade11 = new Grade();
        grade11.setExamScore(3.0);
        grade11.setPartialScore(6.5);
        grade11.setCourse(AA.getName());
        grade11.setStudent((Student) student1);
        gradesAA.add(grade11);

        Grade grade12 = new Grade();
        grade12.setExamScore(3.5);
        grade12.setPartialScore(2.5);
        grade12.setCourse(SO.getName());
        grade12.setStudent((Student) student1);
        gradesSO.add(grade12);

        Grade grade13 = new Grade();
        grade13.setExamScore(5.0);
        grade13.setPartialScore(1.5);
        grade13.setCourse(FIZICA.getName());
        grade13.setStudent((Student) student1);
        gradesFIZICA.add(grade13);

        Grade grade14 = new Grade();
        grade14.setExamScore(7.0);
        grade14.setPartialScore(1.3);
        grade14.setCourse(DEEA.getName());
        grade14.setStudent((Student) student1);
        gradesDEEA.add(grade14);

            Grade grade0 = new Grade();
            grade0.setExamScore(3.0);
            grade0.setPartialScore(1.5);
            grade0.setCourse(AA.getName());
            grade0.setStudent((Student) student2);
            gradesAA.add(grade0);

            Grade grade21=new Grade();
            grade21.setExamScore(3.0);
            grade21.setPartialScore(5.0);
            grade21.setCourse(POO.getName());
            grade21.setStudent((Student) student2);
            gradesPOO.add(grade21);

        Grade grade22=new Grade();
        grade22.setExamScore(2.0);
        grade22.setPartialScore(1.3);
        grade22.setCourse(DEEA.getName());
        grade22.setStudent((Student) student2);
        gradesDEEA.add(grade22);

        Grade grade23=new Grade();
        grade23.setExamScore(3.5);
        grade23.setPartialScore(4.5);
        grade23.setCourse(FIZICA.getName());
        grade23.setStudent((Student) student2);
        gradesFIZICA.add(grade23);

            Grade grade2 = new Grade();
            grade2.setExamScore(4.0);
            grade2.setPartialScore(3.5);
            grade2.setCourse(SO.getName());
            grade2.setStudent((Student) student2);
            gradesSO.add(grade2);


            Grade grade3 = new Grade();
            grade3.setExamScore(2.0);
            grade3.setPartialScore(6.5);
            grade3.setCourse(SO.getName());
            grade3.setStudent((Student) student3);
            gradesSO.add(grade3);

        Grade grade31 = new Grade();
        grade31.setExamScore(2.0);
        grade31.setPartialScore(6.5);
        grade31.setCourse(POO.getName());
        grade31.setStudent((Student) student3);
        gradesPOO.add(grade31);

        Grade grade32 = new Grade();
        grade32.setExamScore(2.0);
        grade32.setPartialScore(6.5);
        grade32.setCourse(AA.getName());
        grade32.setStudent((Student) student3);
        gradesAA.add(grade32);

        Grade grade33 = new Grade();
        grade33.setExamScore(2.5);
        grade33.setPartialScore(3.5);
        grade33.setCourse(FIZICA.getName());
        grade33.setStudent((Student) student3);
        gradesFIZICA.add(grade33);

        Grade grade34 = new Grade();
        grade34.setExamScore(5.0);
        grade34.setPartialScore(2.6);
        grade34.setCourse(DEEA.getName());
        grade34.setStudent((Student) student3);
        gradesDEEA.add(grade34);

            Grade grade4 = new Grade();
            grade4.setExamScore(7.0);
            grade4.setPartialScore(2.5);
            grade4.setCourse(POO.getName());
            grade4.setStudent((Student) student4);
            gradesPOO.add(grade4);

        Grade grade41 = new Grade();
        grade41.setExamScore(4.0);
        grade41.setPartialScore(6.0);
        grade41.setCourse(AA.getName());
        grade41.setStudent((Student) student4);
        gradesAA.add(grade41);

        Grade grade42 = new Grade();
        grade42.setExamScore(7.0);
        grade42.setPartialScore(2.5);
        grade42.setCourse(SO.getName());
        grade42.setStudent((Student) student4);
        gradesSO.add(grade42);

        Grade grade43 = new Grade();
        grade43.setExamScore(7.0);
        grade43.setPartialScore(2.5);
        grade43.setCourse(FIZICA.getName());
        grade43.setStudent((Student) student4);
        gradesFIZICA.add(grade43);

        Grade grade44 = new Grade();
        grade44.setExamScore(7.0);
        grade44.setPartialScore(2.5);
        grade44.setCourse(DEEA.getName());
        grade44.setStudent((Student) student4);
        gradesDEEA.add(grade44);

            Grade grade5 = new Grade();
            grade5.setExamScore(2.0);
            grade5.setPartialScore(1.8);
            grade5.setCourse(FIZICA.getName());
            grade5.setStudent((Student) student5);
            gradesFIZICA.add(grade5);

        Grade grade51 = new Grade();
        grade51.setExamScore(2.0);
        grade51.setPartialScore(1.8);
        grade51.setCourse(DEEA.getName());
        grade51.setStudent((Student) student5);
        gradesDEEA.add(grade51);

        Grade grade52 = new Grade();
        grade52.setExamScore(2.2);
        grade52.setPartialScore(1.8);
        grade52.setCourse(AA.getName());
        grade52.setStudent((Student) student5);
        gradesAA.add(grade52);

        Grade grade53 = new Grade();
        grade53.setExamScore(2.3);
        grade53.setPartialScore(1.3);
        grade53.setCourse(SO.getName());
        grade53.setStudent((Student) student5);
        gradesSO.add(grade53);

        Grade grade54 = new Grade();
        grade54.setExamScore(2.0);
        grade54.setPartialScore(1.8);
        grade54.setCourse(POO.getName());
        grade54.setStudent((Student) student5);
        gradesPOO.add(grade54);

            Grade grade6 = new Grade();
            grade6.setExamScore(9.0);
            grade6.setPartialScore(0.2);
            grade6.setCourse(DEEA.getName());
            grade6.setStudent((Student) student6);
            gradesDEEA.add(grade6);

        Grade grade61 = new Grade();
        grade61.setExamScore(9.0);
        grade61.setPartialScore(0.3);
        grade61.setCourse(FIZICA.getName());
        grade61.setStudent((Student) student6);
        gradesFIZICA.add(grade61);

        Grade grade62 = new Grade();
        grade62.setExamScore(9.0);
        grade62.setPartialScore(0.2);
        grade62.setCourse(AA.getName());
        grade62.setStudent((Student) student6);
        gradesAA.add(grade62);

        Grade grade63 = new Grade();
        grade63.setExamScore(9.0);
        grade63.setPartialScore(0.6);
        grade63.setCourse(SO.getName());
        grade63.setStudent((Student) student6);
        gradesSO.add(grade63);

        Grade grade64 = new Grade();
        grade64.setExamScore(9.0);
        grade64.setPartialScore(0.8);
        grade64.setCourse(POO.getName());
        grade64.setStudent((Student) student6);
        gradesPOO.add(grade64);

            Grade grade7 = new Grade();
            grade7.setExamScore(1.0);
            grade7.setPartialScore(8.5);
            grade7.setCourse(AA.getName());
            grade7.setStudent((Student) student7);
            gradesAA.add(grade7);

        Grade grade71 = new Grade();
        grade71.setExamScore(1.5);
        grade71.setPartialScore(8.5);
        grade71.setCourse(SO.getName());
        grade71.setStudent((Student) student7);
        gradesSO.add(grade71);

        Grade grade72 = new Grade();
        grade72.setExamScore(1.0);
        grade72.setPartialScore(8.8);
        grade72.setCourse(POO.getName());
        grade72.setStudent((Student) student7);
        gradesPOO.add(grade72);

        Grade grade73 = new Grade();
        grade73.setExamScore(1.0);
        grade73.setPartialScore(8.1);
        grade73.setCourse(FIZICA.getName());
        grade73.setStudent((Student) student7);
        gradesFIZICA.add(grade73);

        Grade grade74 = new Grade();
        grade74.setExamScore(1.0);
        grade74.setPartialScore(8.5);
        grade74.setCourse(DEEA.getName());
        grade74.setStudent((Student) student7);
        gradesDEEA.add(grade74);


            Grade grade8 = new Grade();
            grade8.setExamScore(4.0);
            grade8.setPartialScore(3.5);
            grade8.setCourse(POO.getName());
            grade8.setStudent((Student) student8);
            gradesPOO.add(grade8);

        Grade grade81 = new Grade();
        grade81.setExamScore(3.2);
        grade81.setPartialScore(2.5);
        grade81.setCourse(AA.getName());
        grade81.setStudent((Student) student8);
        gradesAA.add(grade81);

        Grade grade82 = new Grade();
        grade82.setExamScore(4.0);
        grade82.setPartialScore(3.7);
        grade82.setCourse(SO.getName());
        grade82.setStudent((Student) student8);
        gradesSO.add(grade82);

        Grade grade83 = new Grade();
        grade83.setExamScore(4.0);
        grade83.setPartialScore(2.5);
        grade83.setCourse(FIZICA.getName());
        grade83.setStudent((Student) student8);
        gradesFIZICA.add(grade83);

        Grade grade84 = new Grade();
        grade84.setExamScore(4.0);
        grade84.setPartialScore(5.5);
        grade84.setCourse(DEEA.getName());
        grade84.setStudent((Student) student8);
        gradesDEEA.add(grade84);

            Grade grade9 = new Grade();
            grade9.setExamScore(7.0);
            grade9.setPartialScore(1.5);
            grade9.setCourse(FIZICA.getName());
            grade9.setStudent((Student) student9);
            gradesFIZICA.add(grade9);

        Grade grade91 = new Grade();
        grade91.setExamScore(7.0);
        grade91.setPartialScore(2.5);
        grade91.setCourse(DEEA.getName());
        grade91.setStudent((Student) student9);
        gradesDEEA.add(grade91);

        Grade grade92 = new Grade();
        grade92.setExamScore(7.0);
        grade92.setPartialScore(1.5);
        grade92.setCourse(POO.getName());
        grade92.setStudent((Student) student9);
        gradesPOO.add(grade92);

        Grade grade93 = new Grade();
        grade93.setExamScore(7.0);
        grade93.setPartialScore(1.5);
        grade93.setCourse(SO.getName());
        grade93.setStudent((Student) student9);
        gradesSO.add(grade93);

        Grade grade94 = new Grade();
        grade94.setExamScore(7.0);
        grade94.setPartialScore(1.5);
        grade94.setCourse(AA.getName());
        grade94.setStudent((Student) student9);
        gradesAA.add(grade94);


            Grade grade10 = new Grade();
            grade10.setExamScore(6.0);
            grade10.setPartialScore(1.5);
            grade10.setCourse(POO.getName());
            grade10.setStudent((Student) student10);
            gradesPOO.add(grade10);

        Grade grade101 = new Grade();
        grade101.setExamScore(2.0);
        grade101.setPartialScore(1.5);
        grade101.setCourse(AA.getName());
        grade101.setStudent((Student) student10);
        gradesAA.add(grade101);

        Grade grade102 = new Grade();
        grade102.setExamScore(6.0);
        grade102.setPartialScore(1.5);
        grade102.setCourse(SO.getName());
        grade102.setStudent((Student) student10);
        gradesSO.add(grade102);

        Grade grade103 = new Grade();
        grade103.setExamScore(6.8);
        grade103.setPartialScore(3.5);
        grade103.setCourse(DEEA.getName());
        grade103.setStudent((Student) student10);
        gradesDEEA.add(grade103);

        Grade grade104 = new Grade();
        grade104.setExamScore(7.1);
        grade104.setPartialScore(2.7);
        grade104.setCourse(POO.getName());
        grade104.setStudent((Student) student10);
        gradesFIZICA.add(grade104);


            catalog.addCourse(POO);
            catalog.addCourse(SO);
            catalog.addCourse(AA);
            catalog.addCourse(FIZICA);
            catalog.addCourse(DEEA);
            System.out.println("\nCursurile adaugate in catalog : "+ catalog.courses);
            //parinti

            Parent parent1 = new Parent("Pavel","Alex");
            Parent parent2 = new Parent("Popescu","Andrei");
            Parent parent3 = new Parent("Ionescu","Vladimir");
            Parent parent4 = new Parent("Palas","Darius");
            Parent parent5 = new Parent("Pop","Mihai");
            Parent parent6 = new Parent("Purariu","Sandu");
            Parent parent7 = new Parent("Deal","Bogdan");
            Parent parent8 = new Parent("Batranu","Cercel");
            Parent parent9 = new Parent("Popescu","Alexis");
            Parent parent10 = new Parent("Dan","Cosmin");
            Parent parent11 = new Parent("Stelian","Teo");

            ((Student) student1).setFather(parent1);
            ((Student) student2).setFather(parent2);
            ((Student) student3).setFather(parent3);
            ((Student) student4).setFather(parent4);
            ((Student) student5).setFather(parent5);
            ((Student) student6).setFather(parent6);
            ((Student) student7).setFather(parent7);
            ((Student) student8).setFather(parent8);
            ((Student) student9).setFather(parent9);
            ((Student) student10).setFather(parent10);
            ((Student) student11).setFather(parent11);

            catalog.addObserver(parent1);
            catalog.addObserver(parent2);
            catalog.addObserver(parent3);
            catalog.addObserver(parent4);
            catalog.addObserver(parent5);
            catalog.addObserver(parent6);
            catalog.addObserver(parent7);
            catalog.addObserver(parent8);
            catalog.addObserver(parent9);
            catalog.addObserver(parent10);
            catalog.addObserver(parent11)
            ;
            System.out.println("\nObservatorii catalogului (parinti) : "+catalog.observers);
            System.out.println("\nNotificarea primita de parintele studentului cu nota grade : ");
            ((Teacher) teacherPOO).accept(scoreVisitor);
            System.out.println("\n");
            ((Assistant) assistant3).accept(scoreVisitor);

            //strategy
        Strategy poostrategy = new BestTotalScore();
        Strategy aastrategy = new BestExamScore();
        Strategy sostrategy = new BestPartialScore();
        Strategy deeastrategy = new BestPartialScore();
        Strategy fizicatrategy = new BestExamScore();
        POO.strategy = poostrategy;
        AA.strategy = aastrategy;
        SO.strategy = sostrategy;
        DEEA.strategy= deeastrategy;
        FIZICA.strategy = fizicatrategy;
        System.out.println("\nStudenti si note poo : "+POO.getAllStudentGrades());
        System.out.println("Cea mai buna nota totala : "+POO.getBestStudent());
        System.out.println("\nStudenti si note AA : "+AA.getAllStudentGrades());
        System.out.println("Cea mai buna nota in examen : "+AA.getBestStudent());
        System.out.println("\nStudenti si note SO : "+SO.getAllStudentGrades());
        System.out.println("Cea mai buna nota in partial : "+SO.getBestStudent());
        System.out.println("\nPOO course grades : "+POO.getGrades());
        POO.makeBackup(); //backup
        gradesPOO.add(grade9);
        System.out.println("\nGrades with an extra wrong grade : "+POO.getGrades());
        POO.undo();
        System.out.println("\nRestored backup : "+POO.getGrades());
        System.out.println("\n" +scoreVisitor.examScores);
System.out.println(FIZICA.getAllStudentGrades());
System.out.println("graduated : " + FIZICA.getGraduatedStudents());



    }

    public static void main(String[] args) throws CloneNotSupportedException {
        new Test();
    }
}

