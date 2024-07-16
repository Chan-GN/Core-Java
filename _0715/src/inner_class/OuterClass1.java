package inner_class;

public class OuterClass {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();

        System.out.println(innerClass.c);
        System.out.println(InnerClass.d);
        innerClass.display();
        InnerClass.printSomething();
    }

    private int a = 5;
    private static int b = 10;
    private class InnerClass {
        private int c = 100;
        private static int d = 500;

        public void display() {
            System.out.println(a + ", " + b + ", " + c + ", " + d);
        }

        public static void printSomething() {
            System.out.println(b + ", " + d);
        }
    }
}
