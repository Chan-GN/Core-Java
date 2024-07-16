package _static;

public class StaticDemo3 {

    private static final int D; // Class Constant
    private static int c; // Class Variable

    static { // Static Initialization Block
        c = 500;
        D = 1000;
    }

    private final int B; // Instance Constant
    private int a; // Instance Variable

    { // Initialization Block
        a = 5;
        B = 100;
    }

    public static void main(String[] args) {
        System.out.println(c + ", " + D);
    }

    void printSomething() {
        int e; // Local Variable
        final int F; // Local Constant
    }

}
