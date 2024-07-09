import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradeManagement2 {
    public static void main(String[] args) throws FileNotFoundException {
        Student[] students = new Student[3];
        Scanner sc = new Scanner(new File(".\\data.dat"));

        int i = 0;
        while (sc.hasNext()) {
            students[i] = new Student();
            String str = sc.nextLine();
            String[] split = str.split("\\s+"); // \s(X) \\s(O)

            students[i].stuId = split[0].trim();
            students[i].name = split[1].trim();
            students[i].kor = Integer.parseInt(split[2].trim());
            students[i].eng = Integer.parseInt(split[3].trim());
            students[i].math = Integer.parseInt(split[4].trim());

            students[i].tot = students[i].kor + students[i].eng + students[i].math;
            students[i].avg = students[i].tot / 3.;

            students[i].grade = (students[i].avg >= 90) ? 'A' : (students[i].avg >= 80) ? 'B' :
                    (students[i].avg >= 70) ? 'C' : (students[i].avg >= 60) ? 'D' : 'F';

            i++;
        }

        for (i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
