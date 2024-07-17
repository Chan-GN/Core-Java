package generics;

import java.util.Vector;

public class GenericDemo2 {

    public static void main(String[] args) {
        Object obj = "Hello";
        // Vector<Object> strings = new Vector<String>(); // Error

        Vector v = new Vector(); // raw type

        Vector<? extends Number> vector1 = new Vector<>();
        // vector1.add(10); // Error

        Vector<? super Integer> vector2 = new Vector<>();
        vector2.add(20);
        Object i1 = vector2.get(0);

        Vector<Integer> vector3 = new Vector<>();
        vector3.add(20);
        Integer i2 = vector3.get(0);

        Product<Integer> pencil = new Product<>(1000);
        Product<Double> pen = new Product<>(100.);

        Product<?> something = new Product<Number>(1000);
    }

}

class Product<T extends Number> {

    private T price;

    public Product(T price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.valueOf(price);
    }

    public void changePrice(T newPrice) {
        this.price = newPrice;
    }

}