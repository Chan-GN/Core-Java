package oop.inheritance;

public class InheritanceDemo {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.breed(); // superclass(Mammal)'s method
        dog.feed(); // superclass(Mammal)'s method
        dog.bark();
        System.out.println(dog.name); // Variable shadowing, 혼란을 방지하기 위해 사용 자제

        Cat cat = new Cat();
        cat.breed();
        cat.feed();
        cat.print();
    }
}
