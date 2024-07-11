import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {
    private Scanner scanner;
    private Student[] students;

    public Input(Student[] students, String fileName) throws FileNotFoundException {
        this.scanner = new Scanner(new File(fileName));
        this.students = students;
    }

    void inputData() {
        for (int i = 0; i < students.length; i++) {
            String line = scanner.nextLine();
            // Parsing
            Scanner sc = new Scanner(line).useDelimiter("\\s+");

            String stuId = sc.next();
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();
            int edp = sc.nextInt();

            students[i] = new Student(stuId, name, kor, eng, math, edp);
        }
    }
}
