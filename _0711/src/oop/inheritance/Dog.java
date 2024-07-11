package oop.inheritance;

public class Dog extends Mammal {
    public String name = "I'm Dog"; // Variable shadowing

    @Override
    public void print() {
        System.out.println("나는 개다.");
    }

    void bark() {
        System.out.println("왈왈");
    }
}
