package inner_class;

public class OuterClass3 {
    public static void main(String[] args) {
        OuterClass3 outerClass3 = new OuterClass3();
        outerClass3.display();
    }

    private void display() {
        int a = 5;
        class InnerClass3 { // Local Inner Class, 변수로 생각하기
            static int c = 500; // Local Inner Class's Class Variable
            int b = 100; // Local Inner Class's Instance Variable

            public void doSomething() {

            }
        }
        InnerClass3 innerClass = new InnerClass3();
        System.out.println(InnerClass3.c);
        System.out.println(innerClass.b); // Cause b is Instance Variable
    }
}
