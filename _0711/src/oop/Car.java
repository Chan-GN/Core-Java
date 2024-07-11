package oop;

/*
 * this : 현재 객체를 가리키는 참조 변수
 * 1. this. : 나의 주소
 * 2. this : 나
 * 3. this() : 나의 생성자
 */
public class Car {
    private String name;
    private int price;

    public Car() {
    /*
        this.name = null;
        this.price = 0;
    */
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        // name = name; // 정상적으로 동작하지 않는다.
        this.name = name; // this.name = 인스턴스 변수
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void go() {
        Engine.accelerate(this); // 현재 객체를 다른 메서드의 매개변수로 전달
    }
}
