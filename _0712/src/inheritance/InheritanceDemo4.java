package inheritance;

public class InheritanceDemo4 {
    public static void main(String[] args) {
        Sonata s1 = new Sonata(); // 상위 클래스 생성자가 먼저 호출된다.
        Sonata s2 = new Sonata("EF inheritance.Sonata", 30_000_000);

        System.out.println(s2);
    }
}

class Car {
    private String name;
    private int price;

    public Car() {
        System.out.println("상위 클래스 생성자 호출");
    }

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Sonata extends Car {
    private String something;

    public Sonata() {
        System.out.println("하위 클래스 생성자 호출");
    }

    public Sonata(String name, int price) {
        super(name, price); // super 메서드로 상위 클래스의 생성자를 호출한다.
    }

    public Sonata(String something) {
        this.something = something;
    }

    public Sonata(String name, int price, String something) {
        super(name, price);
        // this(something); // Error
        this.something = something; // 이렇게 사용해야 한다.
    }

    @Override
    public String toString() {
        return "Name is " + super.getName() + ", price is " + super.getPrice();
    }
}