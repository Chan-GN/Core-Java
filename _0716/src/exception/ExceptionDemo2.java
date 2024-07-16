package exception;

// 메인 클래스
public class ExceptionDemo2 {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("1234-5678", 1000);

        try {
            account.withdraw(500);
            account.withdraw(600);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("부족한 금액: " + e.getAmount() + "원");
        }
    }

}

// 커스텀 예외 클래스
class InsufficientFundsException extends Exception {

    private double amount;

    public InsufficientFundsException(double amount) {
        super("잔액 부족: " + amount + "원이 부족합니다.");
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

}

// 은행 계좌 클래스
class BankAccount {

    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + balance + "원");
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double shortfall = amount - balance;
            throw new InsufficientFundsException(shortfall);
        }
        balance -= amount;
        System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + balance + "원");
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

}

