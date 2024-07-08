public class VariableDemo1 {
    public static void main(String[] args) {
    /*
        String name; // Variable Declaration
        name = "백예린"; // Assignment
        String email = "aaa@aaa.com"; // Initialization
    */

    /*
        System.out.printf("숫자 500 = %d\n", 500);
        System.out.printf("숫자 500 = %o\n", 500); // 8진수
        System.out.printf("숫자 500 = %x\n", 500); // 16진수

        // java truncation
        int a = 5;
        short b = 5; // 왜 에러 안남?
        short c = 7; // 왜 에러 안남?
        short sum = 32767;
        System.out.println(sum); // 엥?
        byte by = 127; // 엥?

        // 실수
        float f = 0.1234567890123456789f;
        double d = 0.1234567890123456789;

        System.out.println("f = " + f);
        System.out.println("d = " + d);
    */
    /*
        // 문자
        System.out.print('A');
        System.out.print('B');
        System.out.print('\n');
        System.out.print('C');
        System.out.print('D');
        System.out.print('\b');
        System.out.print('E');
    */
    /*
        // boolean
        System.out.println(true);
        System.out.println(false);
        System.out.println(4 != 5);
    */
    /*
        // 문자열
        System.out.println("Hello, World!");
    */
    /*
        // scanner, name 사이즈가 같은데 왜 타입을 써줌?
        Scanner scanner = new Scanner(System.in);
        String name = "백예린";
        */
    /*
        byte x = 10;
        byte y = 20;
        byte result = (byte) (x + y); // byte 변수 x,y가 피연산자로 사용되면 int, 즉 강제 형변환을 해줘야함
        // int result = x + y; // 혹은 이렇게 해야함
        byte res = 10 + 20; // 예는 됨
    */

        // 과목 평균 구한다고 치자
        // 형변환 해줘야한다
        int sum = 365;
        int n = 4;
        System.out.println((double) sum / n);

        int number = 5;
        String nToString = String.valueOf(5);
    }
}
