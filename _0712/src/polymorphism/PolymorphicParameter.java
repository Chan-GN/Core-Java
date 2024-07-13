package polymorphism;

class PolymorphicParameter {
    public static void main(String[] args) {
        Vet doctor = new Vet();
        Dog myDog = new Dog();
        Cat myCat = new Cat();
        doctor.vaccinate(myDog);
        doctor.vaccinate(myCat);
    }
}

class Vet {
    void vaccinate(Mammal m) { // Polymorphic Parameter
        System.out.println("vaccinate");
    }
}