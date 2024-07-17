package collections;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        String[] array = {"백예린", "천예린", "만예린", "경예린", "조예린"};
        Queue<String> queue = new LinkedList<>();

        for (String s : array) {
            queue.offer(s);
        }

        System.out.println(queue);
    }

}
