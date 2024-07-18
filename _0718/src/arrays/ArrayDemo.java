package arrays;

import java.util.Arrays;
import java.util.List;

public class ArrayDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 1, 2, 6);

        int[] arr = {1, 5, 6, 2, 7, 9, 8};
        Arrays.sort(arr); // Dual-Pivot Quicksort Algorithm

        for (int i : arr) {
            System.out.println(i);
        }
    }

}
