import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("당신의 이름은?: ");
        String name = scanner.nextLine();
        System.out.printf("반갑습니다. %s님\n", name);
        // System.out.println(name + "님 반갑습니다.");
    }
}
