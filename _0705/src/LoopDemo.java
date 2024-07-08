import java.util.Scanner;

public class LoopDemo {

    public static void main(String[] args) {

    /*
        // A ~ Z까지 출력하기
        for (int i = 0; i < 26; i++) {
            System.out.print((char) (i + 65) + " ");
        }
        System.out.print("\n");

        // Z ~ A까지 출력하기
        for (int i = 25; i >= 0; i--) {
            System.out.print((char) (i + 65) + " ");
        }
        System.out.print("\n");

    */

    /*
        int i = 65;
        int count = 0;
        for (; i <= 90; ) {
            System.out.printf("%c\t", (char) i);
            count++;
            if (count % 5 == 0) System.out.println(); // 한 줄에 5개씩 출력
            i++;
        }
        System.out.println();
    */

    /*
        // 1부터 100까지 4의 배수는 몇개일까?
        int count = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 4 == 0) {
                count++;
            }
        }
        System.out.println("4의 배수의 개수는 " + count + "개 입니다.");
    */

        // Year: 2024
        // 2024년은 윤년입니다.
        // 400년마다 윤년, 4로 나눴을 때 나누어 떨어지며 100으로 나눴을 때 나누어 떨어지지 않는 경우 윤년
        Scanner sc = new Scanner(System.in);

        System.out.print("년도를 입력해주세요: ");
        int year = sc.nextInt();
    /*
        if (year % 400 == 0) {
            System.out.println(year + "년은 윤년입니다.");
        } else if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + "년은 윤년입니다.");
        } else {
            System.out.println(year + "년은 평년입니다.");
        }
    */
        // || 연산자를 사용하여 중복을 줄일 수 있다.
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year + "년은 윤년입니다.");
        } else {
            System.out.println(year + "년은 평년입니다.");
        }

    }

}
