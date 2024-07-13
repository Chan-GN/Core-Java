package _abstract;

public class AbstractDemo {
    public static void main(String[] args) {
        // Animal animal = new Animal(); // Error
        Animal animal = new Tiger();
        animal.display();
    }
}

abstract class Animal {
    public abstract void display(); // Do not have an implementation body

    public void printSomething() {
        System.out.println("나는 수퍼 클래스(Animal)의 그냥 메서드");
    }
}

class Tiger extends Animal {
    @Override
    public void display() {
        System.out.println("나는 서브 클래스(Tiger)의 메서드");
    }
}