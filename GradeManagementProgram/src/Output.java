public class Output {
    private Student[] students;

    public Output(Student[] students) {
        this.students = students;
    }

    public void printResult() {
        for (Student student : students) {
            System.out.printf("%-5s\t%7s\t%5d\t%5d\t%5d\t%5d\t%5d\t%8.1f\t%5c%n"
                    , student.getStuId(), student.getName(), student.getKor(), student.getEng(), student.getMath(),
                    student.getEdp(), student.getTot(), student.getAvg(), student.getGrade());
        }
    }
}
