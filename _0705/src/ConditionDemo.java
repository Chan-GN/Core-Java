import java.util.Scanner;

public class ConditionDemo {

    public static void main(String[] args) {
    /*
        System.out.print("Favorite Season?(spring, summer, fall, winter): ");

        Scanner sc = new Scanner(System.in);
        String season = sc.nextLine(); // season 변수에는 주소값이 저장됨
    */

    /*
        // 문자열 비교는 일반적으로 equals() 메서드를 사용한다.
        // 혹은 compareTo() 메서드를 사용해도 된다. (같으면 0을 반환한다.)
        if (season.equals("spring")) {
            System.out.println("봄: 개나리, 진달래"); // equals()는 String 클래스의 인스턴스 메서드이기 때문에, 주소가 필요하다.
        } else if (season.equals("summer")) {
            System.out.println("여름: 장미, 아카시아");
        } else if (season.compareTo("fall") == 0) {
            System.out.println("가을: 백합, 코스모스");
        } else {
            System.out.println("겨울: 동백, 매화");
        }
    */
    /*
        switch (season) {
            case "spring":
                System.out.println("봄: 개나리, 진달래");
                break;
            case "summer":
                System.out.println("여름: 장미, 아카시아");
                break;
            case "fall":
                System.out.println("가을: 백합, 코스모스");
                break;
            default:
                System.out.println("겨울: 동백, 매화");
                break;
        }
    */

    /*
        // 이름, 신장(cm), 몸무게(kg)를 입력받아 BMI 를 계산하고
        // 다음의 형식으로 출력할 수 있도록 프로그래밍하시오.
        // "오찬근님의 BMI 지수는 23.1이고 비만 전 단계입니다."
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력해주세요.: ");
        String name = sc.nextLine();
        System.out.print("신장을 입력해주세요.: ");
        double height = sc.nextDouble();
        System.out.print("몸무게를 입력해주세요.: ");
        double weight = sc.nextDouble();

        double bmi = weight / ((height / 100) * (height / 100));

        // 앞에 ""%s님의 BMI 지수는 %.1f이고" << 이 부분을 미리 출력하면 중복을 줄일 수 있을듯?
        if (bmi < 18.5) {
            System.out.printf("%s님의 BMI 지수는 %.1f이고 저체중입니다.\n", name, bmi);
        } else if (bmi >= 18.5 && bmi <= 22.9) {
            System.out.printf("%s님의 BMI 지수는 %.1f이고 정상 체중입니다.\n", name, bmi);
        } else if (bmi >= 23 && bmi <= 24.9) {
            System.out.printf("%s님의 BMI 지수는 %.1f이고 비만 전 단계입니다.\n", name, bmi);
        } else if (bmi >= 25 && bmi <= 29.9) {
            System.out.printf("%s님의 BMI 지수는 %.1f이고 1단계 비만입니다.\n", name, bmi);
        } else if (bmi >= 30 && bmi <= 34.9) {
            System.out.printf("%s님의 BMI 지수는 %.1f이고 2단계 비만입니다.\n", name, bmi);
        } else if (bmi >= 35) {
            System.out.printf("%s님의 BMI 지수는 %.1f이고 3단계 비만입니다.\n", name, bmi);
        }
    */

    }

}
