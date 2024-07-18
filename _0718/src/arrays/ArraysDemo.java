package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysDemo {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> list2 = Arrays.asList("백예린", "일예린", "천예린");

        Collections.sort(list1);

        int[] arr = {1, 5, 6, 72, 3, 4, 8, 9, 10};
        Arrays.sort(arr);
        for (int a : arr) {
            System.out.println(a + " ");
        }
    }

}
