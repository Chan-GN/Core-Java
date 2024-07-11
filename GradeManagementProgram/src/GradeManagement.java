import java.io.FileNotFoundException;

public class GradeManagement {
    public static void main(String[] args) throws FileNotFoundException {
        Student[] students = new Student[12];
        String fileName = "sungjuk_utf8.txt";

        Input input = new Input(students, fileName);
        input.inputData();

        Calculator calculator = new Calculator(students);
        calculator.calculate();

        Output output = new Output(students);
        output.printResult();

        System.out.println("Program is Over ...");
    }
}
