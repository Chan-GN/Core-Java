package main.model;

/**
 * 작성자: 이요한
 * 작성일: 2024-08-01
 * 작성 목적
 * - EmployeeDTO
 */
public class EmployeeDTO {

    private String id; // 사원 번호
    private String name; // 사원 이름
    private int basicSalaryCode; // 기본급 코드
    private int nightHours; // 야간 시간
    private int numberOfFamilyMembers; // 가족 수
    private DepartmentCode departmentCode; // 부서명 코드
    private int gradeAllowanceCode; // 호급 수당 코드

    public EmployeeDTO(String id, String name, int basicSalaryCode, int nightHours, int numberOfFamilyMembers, DepartmentCode departmentCode, int gradeAllowanceCode) {
        this.id = id;
        this.name = name;
        this.basicSalaryCode = basicSalaryCode;
        this.nightHours = nightHours;
        this.numberOfFamilyMembers = numberOfFamilyMembers;
        this.departmentCode = departmentCode;
        this.gradeAllowanceCode = gradeAllowanceCode;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBasicSalaryCode() {
        return basicSalaryCode;
    }

    public int getNightHours() {
        return nightHours;
    }

    public int getNumberOfFamilyMembers() {
        return numberOfFamilyMembers;
    }

    public DepartmentCode getDepartmentCode() {
        return departmentCode;
    }

    public int getGradeAllowanceCode() {
        return gradeAllowanceCode;
    }

}