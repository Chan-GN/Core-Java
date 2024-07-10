package oop;


public class Product {
    private String name;
    private int quantity;
    private int sellingPrice;
    private int purchasePrice;
    private int transportation;
    private int profits;
    private double profitRate;

    /*
     * 1) 판매금액 = 수량 * 판매단가
     * 2) 매입금액 = 수량 * 매입단가
     * 3) 이익금 =판매금액 - (매입금액 + 운송료)
     * 4) 이익율 = 이익금 / 매입금액 * 100
     * 5) 이익율은 소수점 이하 셋째 자리에서 반올림하여 둘째 자리까지 구한다.
     */
    public void calculateProfits() {
        int totalSell = quantity * sellingPrice;
        int totalPurchase = quantity * purchasePrice;
        profits = totalSell - (totalPurchase + transportation);
        profitRate = (double) profits / totalPurchase * 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getTransportation() {
        return transportation;
    }

    public void setTransportation(int transportation) {
        this.transportation = transportation;
    }

    public int getProfits() {
        return profits;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
