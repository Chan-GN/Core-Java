package main.model;

/**
 * 작성자 : 오찬근
 * 작성일 : 2024-08-01
 * 작성 목적 : 출력을 위한 DTO 클래스
 * 작성 환경 : Windows 11, JDK 17, Intellij IDEA
 */
public class EmployeeOutputDTO {

    private final String id;
    private final String name;
    private final String departmentCode;
    private final int basicSalaryCode;
    private final int gradeAllowanceSalary;
    private final int familyAllowance;
    private final int nightAllowance;
    private final int totalAmount;
    private final int netIncome;

    public EmployeeOutputDTO(String id, String name, String departmentCode, int basicSalaryCode, int gradeAllowanceSalary,
                             int familyAllowance, int nightAllowance, int totalAmount, int netIncome) {
        this.id = id;
        this.name = name;
        this.departmentCode = departmentCode;
        this.basicSalaryCode = basicSalaryCode;
        this.gradeAllowanceSalary = gradeAllowanceSalary;
        this.familyAllowance = familyAllowance;
        this.nightAllowance = nightAllowance;
        this.totalAmount = totalAmount;
        this.netIncome = netIncome;
    }

    @Override
    public String toString() {
        return String.format("%-9s %-10s %-12s %-11d %-14d %-11d %-12d %-11d %-10d",
                id, name, departmentCode, basicSalaryCode, gradeAllowanceSalary, familyAllowance, nightAllowance,
                totalAmount, netIncome);
    }

    public String getId() {
        return id;
    }

}
