package anonymous;

interface Birds {

    void fly();

    void roam();

}

public class AnonymousClassDemo2 {

    public static void main(String[] args) {
        Birds birds = new Birds() {
            @Override
            public void fly() {
                System.out.println("하늘을 날다.");
            }

            @Override
            public void roam() {
                System.out.println("여기저기 배회하다.");
            }
        };
        birds.fly();
        birds.roam();
    }

}