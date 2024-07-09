public class CopyArrayDemo {
    public static void main(String[] args) {
    /*
        // 주소 복사
        int[] original = {3, 4, 5};
        int[] target = original;

        target[0] = 30;
        System.out.println(original[0]);
    */

        // 값 복사
        int[] original = {3, 4, 5};
        int[] target = new int[10];
        System.arraycopy(original, 0, target, 0, 3);

        for (int t : target) {
            System.out.println(t);
        }
    }
}
