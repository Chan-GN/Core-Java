package my;

public class Employee {
    private final int empId; // 사원 번호
    private final int grade; // 급
    private final int salaryClass; // 호
    private final Salary salary;

    public Employee(int empId, int grade, int salaryClass, int extraPay) {
        this.empId = empId;
        this.grade = grade;
        this.salaryClass = salaryClass;
        this.salary = new Salary(extraPay);
    }

    public String getBasicInfo() {
        return String.format("%-8d %-6d %-4d", getEmpId(), getGrade(), getSalaryClass());
    }

    public String getSalaryInfo() {
        Salary salary = getSalary();
        return String.format("%-8d %-10d %-8d %-12d",
                salary.getExtraPay(),
                salary.getTotalSalary(),
                salary.getTax(),
                salary.getNetAmount());
    }

    public String getInputDataInfo() {
        return String.format("%-5d%-5d%-5d%-10d",
                getEmpId(),
                getGrade(),
                getSalaryClass(),
                getSalary().getExtraPay());
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

    public Salary getSalary() {
        return salary;
    }
}