package polymorphism;

public class HeterogeneousCollections {
    public static void main(String[] args) {
        Mammal[] mammals = new Mammal[4];
        mammals[0] = new Dog();
        mammals[1] = new Cat();
        mammals[2] = new American();
        mammals[3] = new Korean();

        for (Mammal m : mammals) {
            m.saySomething();
        }
    }
}
