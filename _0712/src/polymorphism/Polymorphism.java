package polymorphism;

import java.util.Scanner;

public class Polymorphism {
    public static void main(String[] args) {
        Polymorphism p = new Polymorphism();

        Mammal mammal;

        for (int i = 0; i < 3; i++) {
            int choice = p.choose();
            switch (choice) {
                case 1:
                    mammal = new Dog(); // Upcasting
                    break;
                case 2:
                    mammal = new Cat(); // Upcasting
                    break;
                case 3:
                    mammal = new American(); // Upcasting
                    break;
                default:
                    mammal = new Korean(); // Upcasting
            }
            mammal.saySomething();
        }
    }

    private int choose() {
        System.out.println("************ Menu ************");
        System.out.println("1. Dog");
        System.out.println("2. Cat");
        System.out.println("3. American");
        System.out.println("4. Korean");

        Scanner sc = new Scanner(System.in);
        System.out.print("당신은 어떤 종이십니까? : ");
        return sc.nextInt();
    }
}
