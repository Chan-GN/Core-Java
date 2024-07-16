public class AbstractDemo2 extends Normal2 {

    public AbstractDemo2(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("name = " + getName());
    }

    public static void main(String[] args) {
        Normal2 abstractDemo2 = new AbstractDemo2("백예린");
        abstractDemo2.display();
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
        return "Normal2{" +
                "name='" + name + '\'' +
                '}';
    }
}