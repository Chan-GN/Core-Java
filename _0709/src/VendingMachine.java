import java.util.Scanner;

/**
 * 금액을 입력하면 5만원, 1만원, ..., 1원의 각각의 수를 계산하는 프로그램
 */
public class VendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;

        do {
            int i = 0;
            System.out.print("금액을 입력해주세요.: ");
            int money = sc.nextInt();
            int[] arr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};

            for (int j = 0; j < arr.length; j++) {
                int result = money / arr[i];
                System.out.printf("%d만원 : %d\n", arr[i], result);

                money = money % arr[i];

                i++;
            }
            System.out.print("Again? (Y / N)");
            s = sc.next().toUpperCase();
        } while (s.equals("Y"));

        System.out.println("Program is over ...");
    }
}
