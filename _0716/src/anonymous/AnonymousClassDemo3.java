package anonymous;

interface Mammal {

    void sound();

}

public class AnonymousClassDemo3 {

    public static void main(String[] args) {
        AnonymousClassDemo3 a = new AnonymousClassDemo3();
        Dog dog = new Dog();
        a.display(dog);

        a.display(new Mammal() {
            @Override
            public void sound() {
                System.out.println("냐옹");
            }
        });
    }

    void display(Mammal mammal) { // Polymorphic Parameter
        mammal.sound();
    }
}

class Dog implements Mammal {

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

}