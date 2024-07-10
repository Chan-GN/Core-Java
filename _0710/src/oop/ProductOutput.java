package oop;

public class ProductOutput {
    void output(Product[] products) {
        System.out.println("                            <<상품별 판매 이익금 및 이익율표>>");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("상품명         수량            판매단가         매입단가         운송료        이익금         이익율");
        System.out.println("-------------------------------------------------------------------------------------------");
        for (Product p : products) {
            System.out.printf("%-10s %7d %14d %15d %14d %12d %12.2f\n",
                    p.getName(), p.getQuantity(), p.getSellingPrice(), p.getPurchasePrice(), p.getTransportation(), p.getProfits(), p.getProfitRate());
        }
    }
}
