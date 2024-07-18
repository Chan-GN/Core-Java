package lambda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LambdaDemo4 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "mango", "orange");
        // list에 저장된 각 요소를 반복해서 출력하기
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("--------");

        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("--------");

        list.forEach(System.out::println);
        System.out.println("--------");

        Iterator<String> iterator = list.iterator();
        iterator.forEachRemaining(s -> System.out.println(s));
        System.out.println("--------");

        iterator = list.iterator();
        iterator.forEachRemaining(System.out::println);
    }

}
