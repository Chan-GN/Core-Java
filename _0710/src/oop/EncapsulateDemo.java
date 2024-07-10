package oop;

public class EncapsulateDemo {
    public static void main(String[] args) {
        Car sonata = new Car();
        // sonata.name = "현대 소나타"; // Error, private access
        // sonata.price = 30_000_000; // Error, private access
        sonata.setName("현대소나타");
        sonata.setPrice(30_000_000);

        System.out.println("차량의 이름은 " + sonata.getName() + "이고 가격은 " + sonata.getPrice() + "원 입니다.");
    }
}

class Car {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}