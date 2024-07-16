package inner_class;

public class OuterClass2 {
    private static int b = 10;
    private int a = 5;

    public static void main(String[] args) {
        OuterClass2.InnerClass2 innerClass = new OuterClass2.InnerClass2();
        innerClass.display();
        InnerClass2.printSomething();
    }

    private static class InnerClass2 {
        private static int d = 500;
        private int c = 100;

        public static void printSomething() {
            System.out.println(b + ", " + d);
        }

        public void display() {
            System.out.println(b + ", " + c + ", " + d);
        }
    }
}
