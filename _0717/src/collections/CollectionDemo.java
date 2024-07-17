package collections;

import java.util.*;

public class CollectionDemo {

    public static void main(String[] args) {
        String[] array = {"백예린", "천예린", "만예린", "경예린", "조예린"};
        Set<String> set = new HashSet<>();
        Collections.addAll(set, array);

        // bulk 데이터 추출, Enumeration, Iterator
        Vector<String> vector = new Vector<>(Arrays.asList(array));
        Enumeration<String> enums = vector.elements();
        while (enums.hasMoreElements()) {
            System.out.print(enums.nextElement() + " ");
        }
        System.out.println();

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
