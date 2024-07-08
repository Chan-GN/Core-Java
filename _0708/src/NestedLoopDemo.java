public class NestedLoopDemo {
    public static void main(String[] args) {
        int i = 1; // Initialization
        while (i <= 9) {
            int dan = 2; // Initialization
            while (dan <= 9) {
                System.out.printf("%d X %d = %d\t", dan, i, dan * i);
                dan++; // update
            }
            System.out.println();
            i++; // update
        }
    }
}
