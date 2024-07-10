package oop;

import java.io.FileNotFoundException;

public class ProductManagement {
    public static void main(String[] args) throws FileNotFoundException {
        Product[] products = new Product[7];
        new ProductInput().input(products);
        new ProductCalculator().calculate(products);
        new ProductOutput().output(products);
    }
}
