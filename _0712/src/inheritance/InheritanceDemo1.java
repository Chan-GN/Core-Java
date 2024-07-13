package inheritance;

/**
 * Override Method 는 상속되지 않는다.
 */
public class InheritanceDemo1 {
    public static void main(String[] args) {
        Mammal mammal = new Mammal();
        mammal.display();

        Horse horse = new Horse("제주 말");
        System.out.println(horse);

        horse.display();
    }
}

class Mammal {
    public void display() {
        System.out.println("나는 포유류");
    }
}

class Horse extends Mammal {
    private String name;

    public Horse(String name) {
        // super();
        this.name = name;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("나는 " + name);
    }

    @Override
    public String toString() {
        return "나는 " + name + "입니다.";
    }
}