public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[4];
        for (int i : arr) {
            System.out.println(i);
        }

        for (String s : args) {
            System.out.println(s);
        }
    }
}