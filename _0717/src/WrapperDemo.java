public class WrapperDemo {

    public static void main(String[] args) {
    /*
        // before JDK 1.5
        int num = 5;
        Integer i = new Integer(num);
        int anotherNum = i.intValue();
        System.out.println(anotherNum);
    */

        // after JDK 1.5
        int num = 5;
        Integer i = num; // Auto Boxing
        int anotherNum = i; // Auto Unboxing
    }

}
