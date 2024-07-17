package generics;

import java.util.ArrayList;
import java.util.List;

import static generics.AnimalUtils.*;

public class GenericPractice {

    public static void main(String[] args) {
        Container<Dog> dogContainer = new Container<>();
        dogContainer.setItem(new Dog("개"));
        Container<Cat> catContainer = new Container<>();
        catContainer.setItem(new Cat("고양이"));

        System.out.println(dogContainer.getItem().getName() + ", " + catContainer.getItem().getName());

        printAnimalName(new Dog("멍멍이"));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("강아지"));
        animals.add(new Cat("야옹이"));
        System.out.println("동물 수: " + countAnimals(animals));

        List<Animal> dogs = new ArrayList<>();
        addDog(dogs);
        System.out.println("개 추가 후 동물 수: " + countAnimals(dogs));

        exchangeAnimals(dogContainer, createAnimalContainer(new Dog("바둑이")));
        System.out.println("교환 후 개 이름: " + dogContainer.getItem().getName());

        List<ComparableAnimal> comparableAnimals = new ArrayList<>();
        comparableAnimals.add(new ComparableAnimal("동물2"));
        comparableAnimals.add(new ComparableAnimal("동물1"));
        comparableAnimals.add(new ComparableAnimal("동물3"));

        sortAnimals(comparableAnimals);

        System.out.println("정렬된 동물 이름:");
        for (ComparableAnimal animal : comparableAnimals) {
            System.out.println(animal.getName());
        }
    }

}

// 동물 클래스 계층 구조
abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

class ComparableAnimal extends Animal implements Comparable<Animal> {

    public ComparableAnimal(String name) {
        super(name);
    }

    @Override
    public int compareTo(Animal other) {
        return this.getName().compareTo(other.getName());
    }

}

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public void bark() {
        System.out.println(getName() + " barks");
    }

}

class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public void meow() {
        System.out.println(getName() + " meows");
    }

}

// 제네릭을 사용할 컨테이너 클래스
class Container<T> {

    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

}

// 유틸리티 클래스
class AnimalUtils {

    private AnimalUtils() {
        throw new AssertionError();
    }

    public static <T extends Animal> void printAnimalName(T animal) {
        System.out.println(animal.getName());
    }

    public static int countAnimals(List<? extends Animal> animals) {
        return animals.size();
    }

    public static void addDog(List<? super Dog> dogs) {
        dogs.add(new Dog("새로운 개"));
    }

    public static <T extends Animal> void exchangeAnimals(Container<T> c1, Container<T> c2) {
        T temp = c1.getItem();
        c1.setItem(c2.getItem());
        c2.setItem(temp);
    }

    public static <T extends Animal> Container<T> createAnimalContainer(T animal) {
        Container<T> container = new Container<>();
        container.setItem(animal);

        return container;
    }

    public static <T extends Animal & Comparable<? super T>> void sortAnimals(List<T> animals) {
        animals.sort(null);
    }

}
