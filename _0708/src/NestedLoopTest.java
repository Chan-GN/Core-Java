public class NestedLoopTest {
    public static void main(String[] args) {
        for (int i = 0; i <= 25; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((char) (j + 65));
            }
            System.out.println();
        }
    }
}
