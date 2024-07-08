public class ForDemo {
    public static void main(String[] args) {
        // 짝수 줄, 홀수 줄을 판별하는 방법도 있다.
        int count = 0;
        boolean flag = true;

        for (int i = 65; i <= 90; i++) {
            if (flag) {
                System.out.printf((char) i + "\t");
            } else {
                System.out.printf((char) (i + 32) + "\t");
            }
            count++;
            if (count % 5 == 0) {
                System.out.println();
                flag = !flag;
            }
        }
    }
}
