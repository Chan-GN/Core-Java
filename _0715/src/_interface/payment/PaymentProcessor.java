package _interface.payment;

// 결제 처리를 담당하는 클래스
class PaymentProcessor {
    public void makePayment(PaymentMethod paymentMethod, double amount) {
        if (paymentMethod.isAvailable()) {
            double fee = PaymentMethod.calculateFee(amount);
            paymentMethod.processPayment(amount);
            System.out.println("Payment of $" + amount + " processed successfully using " + paymentMethod.getPaymentType());
            System.out.println("Fee: $" + String.format("%.2f", fee));
            System.out.println("\nReceipt:");
            System.out.println(paymentMethod.generateReceipt(amount));
        } else {
            System.out.println("Payment method " + paymentMethod.getPaymentType() + " is not available.");
        }
    }
}