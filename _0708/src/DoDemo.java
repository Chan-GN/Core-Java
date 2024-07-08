import java.util.Scanner;

public class DoDemo {
    public static void main(String[] args) {
        // 4! 4 * 3 * 2 * 1
        Scanner sc = new Scanner(System.in);
        String ans;
        do {
            System.out.print("수를 입력해주세요: ");
            int su = sc.nextInt();
            int result = 1;

            for (int i = su; i > 0; i--) {
                result *= i;
            }
            System.out.println(su + "! =" + result);
            System.out.println("Again(y / n) ? ");
            ans = sc.next();
        } while (ans.equals("Y") || ans.equals("y"));

    }
}
