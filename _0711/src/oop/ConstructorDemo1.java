package oop;

public class ConstructorDemo1 {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.getName()); // null, 생성자에 의해 필드 초기화
        System.out.println(car.getPrice()); // 0

        Product pencil = new Product("모나미 연필", 1000, "모나미");
        Product computer = new Product("그램", 1_000_000, "LG");
        Product product = new Product();
    }
}