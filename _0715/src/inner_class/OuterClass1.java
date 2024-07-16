package inner_class;

public class OuterClass1 {
    private static int b = 10;
    private int a = 5;

    public static void main(String[] args) {
        OuterClass1 outerClass = new OuterClass1();
        InnerClass1 innerClass = outerClass.new InnerClass1();

        System.out.println(innerClass.c);
        System.out.println(InnerClass1.d);
        innerClass.display();
        InnerClass1.printSomething();
    }

    private class InnerClass1 {
        private static int d = 500;
        private int c = 100;

        public static void printSomething() {
            System.out.println(b + ", " + d);
        }

        public void display() {
            System.out.println(a + ", " + b + ", " + c + ", " + d);
        }
    }
}
