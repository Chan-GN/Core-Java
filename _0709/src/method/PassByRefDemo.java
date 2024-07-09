package method;

/**
 * Pass by Reference Example
 * 사실은 Pass by Value?
 */
public class PassByRefDemo {
    public static void main(String[] args) {
        Product product = new Product();
        product.price = 1000;

        PassByRefDemo p = new PassByRefDemo();

        int temp = product.price; // change 메서드 호출 전 값 저장
        p.change(product);

        System.out.println("change 메서드 호출 이후 " +
                temp + "에서 " + product.price + "으로 변경되었음");
    }

    void change(Product product) {
        product.price = 2000;

        // 참조 자체를 변경하면 원래 참조에는 영향을 미치지 않는다?
        product = new Product();
        product.price = 1000;
    }
}

class Product {
    int price;
}
