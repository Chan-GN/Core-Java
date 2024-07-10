package method;

public class OverloadingDemo {
    public static void main(String[] args) {
        OverloadingDemo o = new OverloadingDemo();
        int n = 3;
        double d = 3.;
        String s = "Some String";

        o.doSomething();
        o.doSomething(n);
        o.doSomething(d);
        o.doSomething(n, s);
        o.doSomething(s, n);
    }

    void doSomething() {
        System.out.println("doSomething() called");
    }

    void doSomething(int n) {
        System.out.println("doSomething(" + n + ") called");
    }

    void doSomething(double n) {
        System.out.println("doSomething(" + n + ") called");
    }

    void doSomething(int n, String s) {
        System.out.println("doSomething(" + n + ", " + s +") called");

    }

    void doSomething(String s, int n) {
        System.out.println("doSomething(" + s + ", " + n +") called");
    }
}
