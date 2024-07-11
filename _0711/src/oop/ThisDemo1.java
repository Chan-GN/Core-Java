package oop;

public class ThisDemo1 {
    public static void main(String[] args) {
        Car car = new Car();
        car.setName("페라리");
        car.setPrice(2_000_000_000);

        System.out.println("이름: " + car.getName() + ", 가격: " + car.getPrice());

        car.go();
    }
}
