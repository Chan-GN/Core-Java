package oop;

public class ProductCalculator {
    void calculate(Product[] products) {
        for (Product p : products) {
            p.calculateProfits();
        }
    }
}
