package method;

/**
 * Method Return Example
 */
public class MethodReturnDemo {
    public static void main(String[] args) {
        MethodReturnDemo m = new MethodReturnDemo();
        System.out.println(m.print(4));
        System.out.println(m.print(5));

        System.out.println(m.getSum(1, 100));
        System.out.println(m.getSum(10, 50));
    }

    private int getSum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }

        return sum;
    }

    String print(int su) {
        System.out.println("Hello");

        if (su % 2 == 0) {
            return "짝수";
        } else {
            return "홀수";
        }
    }
}
