package method;

public class CallByValueOfRefDemo {
    public static void main(String[] args) {
        CallByValueOfRefDemo c = new CallByValueOfRefDemo();
        int n = 3;
        String str = "백예린";
        System.out.println("change 메서드 호출 전 n = " + n + ", str = " + str);
        c.change(n, str);
        System.out.println("change 메서드 호출 후 n = " + n + ", str = " + str);
    }

    void change(int n, String str) {
        n *= 5;
        str = "권진아";
        System.out.println("change 메서드 내부 n = " + n + ", str = " + str);
    }
}
