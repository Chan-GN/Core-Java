import java.util.Scanner;

public class GradeManagement1 {
    public static void main(String[] args) {
        Student s = new Student();
        Scanner sc = new Scanner(System.in);
        String ans;
        do {
            System.out.print("학번 : ");
            s.stuId = sc.next();
            System.out.print("국어 : ");
            s.kor = sc.nextInt();
            System.out.print("영어 : ");
            s.eng = sc.nextInt();
            System.out.print("수학 : ");
            s.math = sc.nextInt();

            s.tot = s.kor + s.eng + s.math;
            s.avg = s.tot / 3.;

            switch ((int) (s.avg / 10)) {
                case 10, 9:
                    s.grade = 'A';
                    break;
                case 8:
                    s.grade = 'B';
                    break;
                case 7:
                    s.grade = 'C';
                    break;
                case 6:
                    s.grade = 'D';
                    break;
                default:
                    s.grade = 'F';
            }

            System.out.printf("%10s\t%5d\t%5d\t%5d\t%5d\t%.1f\t%3c%n"
                    , s.stuId, s.kor, s.eng, s.math, s.tot, s.avg, s.grade);

            System.out.print("또 진행하시겠습니까?(Y/N): ");
            ans = sc.next();
        } while (ans.equals("Y") || ans.equals("y"));

        System.out.println("Program is Over ...");
    }
}
