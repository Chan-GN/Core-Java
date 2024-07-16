package _abstract;

public class AbstractDemo1 extends Normal1 {
    public AbstractDemo1(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Normal1 normal = new AbstractDemo1("백예린"); // Upcasting
        System.out.println(normal); // normal.toString()
        System.out.println(normal.getClass()); // normal.toString()
    }
}

abstract class Normal1 {
    private String name;

    public Normal1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Normal1{" +
                "name='" + name + '\'' +
                '}';
    }
}