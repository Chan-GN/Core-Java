package method;

/**
 * Call(Pass) by Name, Value
 */
public class MethodDemo {
    public static void main(String[] args) {
        MethodDemo methodDemo = new MethodDemo();

        methodDemo.printSum(); // Call(Pass) by Name

        int start = 1, end = 100;
        methodDemo.printSum(start, end); // Call(Pass) by Value
    }

    void printSum() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1부터 100까지의 합은 " + sum + "입니다.");
    }

    // Call(Pass) by Value
    void printSum(int start, int end) {
        /*
         * Call(Pass) by Value 는 전달받은 값을 복사하는 개념이므로,
         * 메서드 내부에서 값을 변경하더라도 호출한 블록 내부의 변수의 값은 변경 X
         */
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println(start + "부터 " + end + "까지의 합은 " + sum + "입니다.");
    }
}

/*
 * 1. PascalCasing : Class, Interface, Enum
 * 2. camelCasing : variable, method
 * 3. snake_Casing
 * 4. kebab-Casing
 * 5. UPPER_SNAKE_CASE : constant variable
 */
