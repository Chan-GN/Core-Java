package wrapper;

public class WrapperDemo {

    public static void main(String[] args) {
        int num = 5; // stack

        Integer i = new Integer(5);
        int another = i.intValue();

        Integer integer = num * 100; // Auto Boxing
        int another2 = integer; // Auto Unboxing
    }

}
