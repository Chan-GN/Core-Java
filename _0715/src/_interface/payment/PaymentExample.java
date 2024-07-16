package _interface;

public class PaymentExample {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        // 신용카드 결제
        PaymentMethod creditCard = new CreditCardPayment("1234-5678-9012-3456", "12/25");
        processor.makePayment(creditCard, 100.50);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // PayPal 결제
        PaymentMethod payPal = new PayPalPayment("user@example.com");
        processor.makePayment(payPal, 75.25);
    }
}