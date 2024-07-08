public class VariableDemo {

    static int math = 80; // Class Variable
    int eng = 100; // Instance Variable

    public static void main(String[] args) {
        int kor = 90; // Local Variable (Must be Initialized)

        System.out.println("Math score = " + VariableDemo.math);
        System.out.println("Math score = " + math);

        System.out.println("Math score = " + Demo.math);

        System.out.println("Korean score = " + kor);
        // System.out.println("English score = " + eng); // Error

        VariableDemo vd = new VariableDemo();
        System.out.println("English score = " + vd.eng);

        Demo d = new Demo();
        System.out.println("English score = " + d.eng);
    }

}

class Demo {
    static int math = 70; // Class Variable
    int eng = 40; // Instance Variable
}