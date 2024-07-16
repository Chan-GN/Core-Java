package inner_class;

public class LocalInnerClassDemo {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.display();
    }

}

class OuterClass {

    private static int b = 10;
    private int a = 5;

    public void display() {
        int c = 100; // final
        class InnerClass {
            public void print() {
                System.out.println(c);
                // c = 1000; // Error
            }
        }
        InnerClass innerClass = new InnerClass();
    }

}