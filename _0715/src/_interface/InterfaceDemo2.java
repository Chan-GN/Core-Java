package _interface;

public class InterfaceDemo2 {
    public static void main(String[] args) {
        Product product = new Product("모나미 연필");
        Product pen = product;
        System.out.println(pen.getName());
        System.out.println(product.equals(pen));

        Product cloned = product.clone();
        System.out.println(cloned.getName());
        System.out.println(product.equals(cloned));
    }
}

class Product implements Cloneable {
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Product clone() {
        Product target = null;
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}