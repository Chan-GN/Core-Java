package _enum;

public class EnumDemo {

    public static void main(String[] args) throws ReflectiveOperationException {
        Season fall = Season.FALL;

        System.out.println(fall);
        System.out.println(fall.ordinal());
        System.out.println(fall.getValue());
    }

}
