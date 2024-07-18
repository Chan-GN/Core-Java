package lambda;

@FunctionalInterface
interface MyInterface {

    int add(int a, int b);

}

/*
 * Lambda Expression
 *
 * 원래 객체지향 언어에서 사용하지 않고, Scala나 Groovy 같은 함수형 언어에서 주로 사용하던 문법
 * 'Expression'이라고 부르는 이유는 메소드와 역할이 동일하지만 특정 클래스에 소속되지 않기 때문
 * Lambda Expression을 사용하면 매개변수와 리턴 타입만으로 간단히 코드를 작성할 수 있어, Collection Framework에서 효과적인 코드 작성이 가능
 * Lambda Expression은 병렬 프로그래밍을 쉽게 구현할 수 있게 해줌
 *
 * Lambda Expression 작성 순서
 *
 * 1. 객체의 생성 부분 삭제
 * 2. @Override 어노테이션 삭제
 * 3. 접근 지정자, 리턴 타입, 메소드 이름 삭제
 * 4. 파라미터 타입 삭제
 *    - 컴파일러가 타입을 추론할 수 있다면 파라미터 타입 삭제 가능
 *    - 추론이 불가능하면 모든 파라미터의 타입 명시
 * 5. 메소드 바디의 return 키워드 삭제 (단일 표현식인 경우)
 * 6. 메소드 구현부의 문장이 한 개일 경우, 메소드 () 뒤 {} 삭제
 * 7. 메소드의 파라미터 선언부 괄호 뒤와 {} 사이를 -> 연산자로 연결
 */
public class LambdaDemo1 {

    public static void main(String[] args) {
        int a = 5, b = 10;
        Calculator calculator = new Calculator();
        int sum1 = calculator.add(a, b);
        System.out.println("sum = " + sum1);

        MyInterface myInterface1 = new MyInterface() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };

        int sum2 = myInterface1.add(a, b);
        System.out.println("sum = " + sum2);

        MyInterface myInterface2 = (c, d) -> c + d;
    }

}

class Calculator implements MyInterface {

    @Override
    public int add(int a, int b) {
        return a + b;
    }

}