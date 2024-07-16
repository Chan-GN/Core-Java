package anonymous;

public class AnonymousClassDemo1 {

    public static void main(String[] args) {
        Canine1 canine = new Canine1() {
            @Override
            void bark() {
                System.out.println("으르렁 짖다.");
            }

            void display() {
                System.out.println("추가한 메서드");
            }
        };

        canine.bark();
        canine.roam();
        // canine.display(); // Error

    }

}

abstract class Canine1 {

    abstract void bark();

    void roam() {
        System.out.println("여기저기 배회하다.");
    }

}

class Dog1 extends Canine1 {

    @Override
    void bark() {
        System.out.println("으르렁 짖다.");
    }

}