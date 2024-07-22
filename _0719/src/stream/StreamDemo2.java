package stream;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class StreamDemo2 {

    public static void main(String[] args) {
        IntStream is = IntStream.range(1, 101);
        // int reduce = is.reduce(0, (x, y) -> x + y);
        is.reduce(0, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
    }

}
