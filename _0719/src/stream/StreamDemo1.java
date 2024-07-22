package stream;

import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamDemo1 {

    public static void main(String[] args) {
        long count = IntStream.rangeClosed(1, 100).count();
        System.out.println(count);

        // 1.0 ~ 100.0 난수 15개 중 최댓값
        OptionalDouble max = new Random().doubles(15L, 1.0, 100.0).min();
        max.ifPresent(System.out::println);

        // 한번 소비된 Stream -> 재사용할 수 없음
        IntStream intStream = IntStream.rangeClosed(1, 100);
        int sum = intStream.sum(); // Terminal Operation
        // long c = intStream.count(); // Terminal Operation, IllegalStateException(Already consumed)

        // 1 ~ 100 난수 발생, 중복 배제, 5개 추출, 정렬
        new Random()
                .ints(1, 100)
                .distinct()
                .limit(5)
                .sorted()
                .forEach((i) -> System.out.println("i = " + i));
    }

}
