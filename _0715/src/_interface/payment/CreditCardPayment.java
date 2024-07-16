package _interface;

// 신용카드 결제 구현
class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String expiryDate) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card number: " + cardNumber);
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }
}