import java.util.Scanner;

public class OperatorDemo {
    public static void main(String[] args) {
    /*
        short su = 5;
        short result = ~su; // Error
    */
    /*
        // 3항 연산자는 조건을 먼저 보지 않고, 참과 거짓의 값을 먼저 비교한다.
        // 이에, 아래의 경우 1980이라는 리터럴이 double 타입으로 자동 형변환된다.
        short result = true ? 1980 : 3.14; // Error
    */
        Scanner sc = new Scanner(System.in);

        System.out.print("초를 입력해주세요.: ");
        int i = sc.nextInt();

        int hour = i / 3600;
        int min = (i % 3600) / 60;
        int sec = i % 60;

        System.out.printf("%d초는 %d시간 %d분 %d초입니다.\n", i, hour, min, sec);
    }
}
