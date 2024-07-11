package oop.inheritance;

public class Cat extends Mammal {
    public String name = "I'm Cat"; // Variable shadowing

    @Override
    public void print() {
        System.out.println("나는 고양이다.");
    }
}
