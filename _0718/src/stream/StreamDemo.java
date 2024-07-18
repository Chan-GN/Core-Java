package stream;

/*
 * Stream API
 *
 * 1. Stream? : 배열이나 Collection과 같이 여러 개의 데이터를 순차적으로 처리하기 위해 Java 8에서 도입된 기능
 * 2. Data를 Stream으로 처리하기 위해서는 먼저 Stream 객체를 생성해야 함
 * 3. Stream API의 3가지 주요 단계
 *    1) Stream 생성
 *    2) 생성된 Stream을 가공하는 중간 연산 (Intermediate Operations)
 *    3) 최종적으로 결과를 만드는 최종 연산 (Terminal Operations)
 * 4. 연산의 결과가 Stream으로 리턴되면 중간 연산이라고 함. 반면, 연산의 결과가 Stream이 아닌 형태로 나타나면 최종 연산이라고 함
 * 5. 중간 연산의 결과가 Stream으로 리턴되기 때문에, Stream 연산을 계속 이어서 chain 형태로 이용할 수 있음
 * 6. 최종 연산의 결과는 Stream이 아니기 때문에 최종 연산을 수행하면 Stream이 소모되어 다시 다른 Stream 연산을 수행할 수 없음
 * 7. Stream 연산은 원본 데이터를 읽어서 기능을 수행하지만, 그 내용을 변경하지 않음 (불변성)
 * 8. Stream은 지연 평가(Lazy Evaluation)를 사용하여 효율성을 높임. 즉, 최종 연산이 호출되기 전까지는 중간 연산이 실제로 수행되지 않음
 * 9. Stream은 병렬 처리를 쉽게 구현할 수 있도록 설계되었으며, parallelStream()을 사용하여 간단하게 병렬 처리를 할 수 있음
 * 10. Stream은 일회용임. 한 번 사용한 Stream은 재사용할 수 없으며, 필요하다면 새로운 Stream을 생성해야 함
 * 11. 주요 중간 연산: filter(), map(), flatMap(), distinct(), sorted(), limit(), skip() 등
 * 12. 주요 최종 연산: forEach(), collect(), reduce(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(), findAny() 등
 */

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        // Stream 생성 : Array와 Collection은 생성 방식이 다름
        // 배열로부터 Stream 생성
        Integer[] intArray = {1, 2, 3, 4, 5};
        Stream<Integer> s1 = Stream.of(intArray);

        String[] strArray = {"사과", "배", "딸기", "복숭아", "레몬", "망고", "수박"};
        Stream<String> s2 = Stream.of(strArray);

        // Arrays로부터 Stream 생성
        Stream<Integer> s3 = Arrays.stream(intArray);
        Stream<String> s4 = Arrays.stream(strArray);

        // Collection으로부터 Stream 생성
        List<String> list = Arrays.asList("사과", "배", "딸기", "복숭아", "레몬", "망고", "수박");
        Stream<String> s5 = list.stream();

        List<Integer> list1 = Arrays.asList(3, 4, 7, 1, 2, 3);
        Stream<Integer> s6 = list1.stream();

        Set<String> set =
                new HashSet<>(Arrays.asList("사과", "배", "딸기", "복숭아", "레몬", "망고", "수박"));
        Stream<String> s7 = set.stream();

        // 지정된 범위를 이용해서 만드는 Stream
        IntStream is = IntStream.range(1, 11);   // 1부터 10까지
        DoubleStream ds = DoubleStream.of(10.5);

        // 난수를 발생하여 Stream 생성하기
        DoubleStream ds1 = new Random().doubles(15L, 1.0, 10.0);
        IntStream is1 = new Random().ints(5, 1, 10); // 1부터 10까지 중 난수 5개
    }

}
