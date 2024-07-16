package _interface.payment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

interface PaymentMethod {
    double CHARGE = 0.02; //  public static final

    // 결제 수수료 계산을 위한 static 메서드
    static double calculateFee(double amount) {
        return amount * CHARGE; // 2% 수수료 가정
    }

    void processPayment(double amount);

    boolean isAvailable();

    String getPaymentType();

    // 결제 후 영수증 생성을 위한 default 메서드
    default String generateReceipt(double amount) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("Receipt for %s payment\nAmount: $%.2f\nDate: %s\nPayment Type: %s",
                getPaymentType(), amount, now.format(formatter), getPaymentType());
    }
}