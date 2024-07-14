package team;

public class Employee {
    private int empId; // 사원 번호
    private int grade; // 급
    private int salaryClass; // 호
    private int extraPay; // 수당
    private int totalSalary; // 지급액
    private int tax; // 세금
    private int netAmount; // 차인 지급액
    private double taxRate; // 세율
    private int baseSalary; // 급여
    private int adjAmount; // 조정액

    public Employee(int empId, int grade, int salaryClass, int extraPay) {
        this.empId = empId;
        this.grade = grade;
        this.salaryClass = salaryClass;
        this.extraPay = extraPay;
    }

    public int getEmpId() {
        return empId;
    }

    public int getGrade() {
        return grade;
    }

    public int getSalaryClass() {
        return salaryClass;
    }

    public int getExtraPay() {
        return extraPay;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public int getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(int netAmount) {
        this.netAmount = netAmount;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getAdjAmount() {
        return adjAmount;
    }

    public void setAdjAmount(int adjAmount) {
        this.adjAmount = adjAmount;
    }

    @Override
    public String toString() {
        return "team.Employee{" +
                "empId=" + empId +
                ", grade=" + grade +
                ", salaryClass=" + salaryClass +
                ", extraPay=" + extraPay +
                ", totalSalary=" + totalSalary +
                ", tax=" + tax +
                ", netAmount=" + netAmount +
                ", taxRate=" + taxRate +
                ", baseSalary=" + baseSalary +
                ", adjAmount=" + adjAmount +
                '}';
    }
}