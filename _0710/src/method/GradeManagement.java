package method;

public class GradeManagement {
    public static void main(String[] args) {
        Student chan = new Student();

        new Input().input(chan);
        new Calculator().calc(chan);
        new Output().output(chan);
    }
}
