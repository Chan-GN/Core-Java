package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ListDemo {

    public static void main(String[] args) {
        String[] strings = {"어", "라", "라", "로", " 라"};
        List<String> list = new ArrayList<>(); // DEFAULT_CAPACITY = 10

        for (String element : strings) {
            list.add(element);
        }

        System.out.println("현재 방개수 : " + list.size());
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        System.out.println(list.get(1));

        Vector<String> vector = new Vector<>(1, 1);
    }

}
