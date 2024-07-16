package _interface.car;

public class InterfaceDemo {
    public static void main(String[] args) {
        Car c1 = new Car("EF소나타", 30_000_000);
        Car c2 = new Car("RedMatiz", 10_000_000);

        int result = c1.compareTo(c2);
        System.out.println(result);
    }
}

class Car implements Comparable<Car> {
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Car anotherCar) {
        return price - anotherCar.price;
    }
}