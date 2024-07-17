package collections;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        String[] array = {"백예린", "천예린", "만예린", "경예린", "조예린"};
        Stack<String> stack = new Stack<>();

        for (String s : array) {
            stack.push(s);
        }
        System.out.println(stack.peek());

        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

}
