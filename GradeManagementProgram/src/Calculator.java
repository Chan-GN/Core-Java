public class Calculator {
    private Student[] students;

    public Calculator(Student[] students) {
        this.students = students;
    }

    void calculate() {
        for (Student student : students) {
            int tot = student.getKor() + student.getEng() + student.getMath() + student.getEdp();
            double avg = tot / 4.;
            char grade = (avg >= 90) ? 'A' : (avg >= 80) ? 'B' :
                    (avg >= 70) ? 'C' : (avg >= 60) ? 'D' : 'F';

            student.setTot(tot);
            student.setAvg(tot);
            student.setGrade(grade);
        }
    }
}
