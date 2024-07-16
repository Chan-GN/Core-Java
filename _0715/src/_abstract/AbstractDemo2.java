package _abstract;

public class AbstractDemo2 extends Normal2 {
    public AbstractDemo2(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Normal2 abstractDemo2 = new AbstractDemo2("백예린");
        abstractDemo2.display();
    }

    @Override
    public void display() {
        System.out.println("name = " + getName());
    }
}

abstract class Normal2 {
    private String name;

    public Normal2(String name) {
        this.name = name;
    }

    public abstract void display();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "_abstract.Normal2{" +
                "name='" + name + '\'' +
                '}';
    }
}