package _static;

public class StaticDemo2 {

    private static int b = printSomething(); // Class Variable
    private int a; // Instance Variable

    public static void main(String[] args) {
        System.out.println("나는 메인 메서드");
    }

    static int printSomething() { // Class Method
        System.out.println("나는 클래스 메서드");
        return 30_000_000;
    }

    void display() { // Instance Method

    }

}
