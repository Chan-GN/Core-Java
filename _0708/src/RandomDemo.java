import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        // int r = (int) (Math.random() * 10) + 1; // 방법 1

        Random random = new Random();
        int r = random.nextInt(10) + 1; // 방법 2

        System.out.println("Random number is " + r);
        switch (r) {
            case 1:
                System.out.println("Bananas");
                break;
            case 2:
                System.out.println("Oranges");
                break;
            case 3:
                System.out.println("Peach");
            case 4:
                System.out.println("Apples");
            case 5:
                System.out.println("Plums");
                break;
            case 6:
                System.out.println("Pineapples");
                break;
            case 7:
                System.out.println();
                break;
            default:
                System.out.println("Nuts");
                // break; // 마지막에 위치 시 생략 가능
        }
    }
}
