package my;

public class Salary {
    private final int extraPay; // 수당
    private int totalSalary; // 지급액
    private int tax; // 세금
    private int netAmount; // 차인 지급액
    private int baseSalary; // 급여

    public Salary(int extraPay) {
        this.extraPay = extraPay;
    }

    public int getExtraPay() {
        return extraPay;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public int getTax() {
        return tax;
    }

    public int getNetAmount() {
        return netAmount;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void calculate(int grade, int salaryClass) {
        baseSalary = getBaseSalary(grade, salaryClass);
        totalSalary = baseSalary + extraPay;
        double taxRate = getTaxRate(totalSalary);
        int adjAmount = getAdjAmount(totalSalary);
        tax = (int) Math.round(totalSalary * taxRate) - adjAmount;
        netAmount = totalSalary - tax;
    }

    private int getBaseSalary(int grade, int salaryClass) {
        if (grade == 1) {
            return 98_000 - (3_000 * salaryClass);
        }
        if (grade == 2) {
            return 85_000 - (5_000 * salaryClass);
        }
        return 0;
    }

    private double getTaxRate(int totalSalary) {
        if (totalSalary >= 90_000) {
            return 0.012;
        }
        if (totalSalary >= 80_000) {
            return 0.007;
        }
        if (totalSalary >= 70_000) {
            return 0.005;
        }
        return 0;
    }

    private int getAdjAmount(int totalSalary) {
        if (totalSalary >= 90_000) {
            return 1000;
        }
        if (totalSalary >= 80_000) {
            return 500;
        }
        if (totalSalary >= 70_000) {
            return 300;
        }
        return 0;
    }
}
