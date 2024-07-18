package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaExamples {

    public static void main(String[] args) {
        // 1. 매개변수가 없고, 반환값이 없는 경우
        Runnable runnable = () -> System.out.println("Hello, Lambda!");

        // 2. 매개변수가 하나이고, 반환값이 없는 경우
        Consumer<String> consumer = (s) -> System.out.println(s);

        // 3. 매개변수가 하나이고, 괄호 생략 (타입 추론 가능한 경우)
        Consumer<String> consumerNoBrackets = s -> System.out.println(s);

        // 4. 매개변수가 여러 개이고, 반환값이 있는 경우
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        // 5. 매개변수의 타입을 명시적으로 지정한 경우
        BiFunction<Integer, Integer, Integer> subtract = (Integer a, Integer b) -> a - b;

        // 6. 본문이 여러 줄인 경우
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> {
            System.out.println("Multiplying " + a + " and " + b);
            return a * b;
        };

        // 7. 메서드 참조 사용 (인스턴스 메서드)
        String str = "Hello";
        Supplier<Integer> lengthSupplier = str::length;

        // 8. 메서드 참조 사용 (정적 메서드)
        Function<Double, Long> roundFunction = Math::round;

        // 9. 생성자 참조
        Supplier<List<String>> listSupplier = ArrayList::new;

        // 10. 람다 표현식을 메서드의 인자로 직접 전달
        executeAndPrint((x, y) -> x / y, 10, 2);
    }

    // 람다 표현식을 인자로 받는 메서드 예시
    public static void executeAndPrint(BiFunction<Integer, Integer, Integer> func, int a, int b) {
        System.out.println("Result: " + func.apply(a, b));
    }

}