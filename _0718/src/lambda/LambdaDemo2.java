package lambda;

@FunctionalInterface
interface Comparable {

    int compare(int front, int back);

}

/*
 * @FunctionalInterface
 *
 * 정의
 * - 정확히 하나의 추상 메서드를 가지는 인터페이스를 나타내는 어노테이션
 * - Java 8에서 도입되었으며, Lambda Expression과 함께 사용됨
 *
 * 특징
 * - 일반적으로 인터페이스는 여러 개의 추상 메서드를 가질 수 있음
 * - 그러나 @FunctionalInterface가 붙은 인터페이스는 단 하나의 추상 메서드만 가질 수 있음
 * - 둘 이상의 추상 메서드가 있으면 컴파일 에러가 발생함
 *
 * 목적
 * - Lambda Expression에서 사용할 인터페이스임을 명시적으로 선언함
 * - 컴파일러가 해당 인터페이스가 함수형 인터페이스의 요구사항을 충족하는지 검사함
 *
 * 주의사항
 * - 디폴트 메서드와 static 메서드는 여러 개 가질 수 있음
 * - Object 클래스의 public 메서드를 오버라이드하는 메서드는 추상 메서드 카운트에 포함되지 않음
 */
public class LambdaDemo2 {

    public static void main(String[] args) {
        int a = 5, b = 10;
        Comparable comparable = new Comparable() {

            @Override
            public int compare(int front, int back) {
                return front - back;
            }
        };
        int result = comparable.compare(a, b);
        System.out.println(result);

        calculator((front, back) -> front - back);
    }

    private static void calculator(Comparable comparable) {
        int a = 5, b = 10;
        int result = comparable.compare(a, b);

        System.out.println("result = " + result);
    }

}