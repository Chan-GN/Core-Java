package oop;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductInput {
    void input(Product[] products) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(".\\productdata.txt"));

        int i = 0;
        while (sc.hasNext()) {
            products[i] = new Product();
            String str = sc.nextLine();
            String[] split = str.split("\\s+");

            products[i].setName(split[0].trim());
            products[i].setQuantity(Integer.parseInt(split[1].trim()));
            products[i].setSellingPrice(Integer.parseInt(split[2].trim()));
            products[i].setPurchasePrice(Integer.parseInt(split[3].trim()));
            products[i].setTransportation(Integer.parseInt(split[4].trim()));

            i++;
        }
    }
}
