package generics;

public class GenericDemo1 {

    public static void main(String[] args) {
        Car<Integer> car1 = new Car<>(40_000_000);
        car1.changePrice(45_000_000);
        System.out.println(car1);

        Car<Double> car2 = new Car<>(45000000.);
        car2.changePrice(50000000.);
        System.out.println(car2);

        System.out.println(car1.getPrice().getClass() + ", " + car2.getPrice().getClass());
    }

}

class Car<T extends Number> {

    private T price;

    public Car(T price) {
        this.price = price;
    }

    public T getPrice() {
        return price;
    }

    public void changePrice(T price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "generics.Car{" +
                "price=" + price +
                '}';
    }

}