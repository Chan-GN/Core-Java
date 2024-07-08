import java.util.Scanner;

public class GradeManagement2 {
    public static void main(String[] args) {
    /*
        Student[] students = new Student[2];
        students[0] = new Student();
        students[1] = new Student();
    */

        Student[] students = new Student[]{new Student(), new Student()};

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.print("학번 : ");
            students[i].stuId = sc.next();
            System.out.print("국어 : ");
            students[i].kor = sc.nextInt();
            System.out.print("영어 : ");
            students[i].eng = sc.nextInt();
            System.out.print("수학 : ");
            students[i].math = sc.nextInt();

            students[i].tot = students[i].kor + students[i].eng + students[i].math;
            students[i].avg = students[i].tot / 3.;

            switch ((int) (students[i].avg / 10)) {
                case 10, 9:
                    students[i].grade = 'A';
                    break;
                case 8:
                    students[i].grade = 'B';
                    break;
                case 7:
                    students[i].grade = 'C';
                    break;
                case 6:
                    students[i].grade = 'D';
                    break;
                default:
                    students[i].grade = 'F';

            }
        }
        for (Student s : students) {
            System.out.printf("%10s\t%5d\t%5d\t%5d\t%5d\t%.1f\t%3c%n"
                    , s.stuId, s.kor, s.eng, s.math, s.tot, s.avg, s.grade);
        }
    }
}
