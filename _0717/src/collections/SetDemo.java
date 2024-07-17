package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        String[] array = {"백예린", "천예린", "만예린", "백예린"};
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>(); // Sorted

        for (String element : array) {
            hashSet.add(element);
            treeSet.add(element);
        }

        System.out.println("hashSet = " + hashSet);
        System.out.println("treeSet = " + treeSet);
    }

}
