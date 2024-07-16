package _interface;

// PayPal 결제 구현
class PayPalPayment implements PaymentMethod {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("PayPal account: " + email);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String getPaymentType() {
        return "PayPal";
    }

    // PayPal 전용 영수증 생성 메서드 (default 메서드 오버라이드)
    @Override
    public String generateReceipt(double amount) {
        String basicReceipt = PaymentMethod.super.generateReceipt(amount);
        return basicReceipt + "\nPayPal Transaction ID: " + generateTransactionId();
    }

    private String generateTransactionId() {
        return "PP-" + System.currentTimeMillis();
    }
}