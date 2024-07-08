import java.util.Scanner;

public class ProductManagement {
    public static void main(String[] args) {
    /*
        Product pencil = new Product();
        pencil.name = "모나미 연필";
        pencil.price = 1000;

        System.out.println(pencil);

        Product computer = new Product();
        computer.name = "컴퓨터";
        computer.price = 2000000;

        System.out.println(computer);
    */
        // Product[] products = new Product[]{new Product(), new Product()};
        Product[] products = {new Product(), new Product()};
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (i < 2) {
            System.out.print("상품의 이름을 입력하세요.: ");
            products[i].name = sc.next();
            System.out.print("상품의 가격을 입력하세요.: ");
            products[i].price = sc.nextInt();

            i++;
        }

        for (int j = 0; j < 2; j++) {
            System.out.printf("Name = %s, Price = %,d원%n", products[j].name, products[j].price);
        }
    }
}
