import java.util.Scanner;

public class VariableDemo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("국어 점수: ");
        int ko = Integer.parseInt(scanner.nextLine());
        System.out.print("수학 점수: ");
        int math = Integer.parseInt(scanner.nextLine());
        System.out.println("총점은 " + (ko + math) + "점 입니다.");

        // 정수형 -> 문자열 형변환
        int test = 100;
        String s = String.valueOf(test);

        // 문자열 -> 정수형 형변환
        String test2 = "100";
        int i = Integer.parseInt(test2);
    }
}
