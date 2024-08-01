package main.controller;

import main.model.EmployeeDAO;
import main.model.EmployeeDTO;
import main.model.EmployeeOutputDTO;
import main.util.CalculateUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 작성자 : 오찬근
 * 작성일 : 2024-08-01
 * 작성 목적 : Select 담당 컨트롤러
 * 작성 환경 : Windows 11, JDK 17, Intellij IDEA
 */
public class SelectController {

    private final EmployeeDAO employeeDAO;

    public SelectController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public List<EmployeeOutputDTO> getAllEmployees() {
        List<EmployeeDTO> employees = employeeDAO.findAll();

        return convert(employees);
    }

    private List<EmployeeOutputDTO> convert(List<EmployeeDTO> employees) {
        return employees.stream()
                .map(e -> {
                    int gradeAllowanceSalary = CalculateUtils.calculateGradeAllowanceSalary(e.getGradeAllowanceCode());
                    int nightAllowance = CalculateUtils.calculateNightAllowance(e.getNightHours());
                    int familyAllowance = CalculateUtils.calculateFamilyAllowance(e.getNumberOfFamilyMembers());
                    int basicSalary = CalculateUtils.calculateBasicSalary(e.getBasicSalaryCode());
                    int totalAmount = CalculateUtils.calculateTotalAmount(
                            gradeAllowanceSalary, basicSalary, nightAllowance, familyAllowance
                    );
                    int netIncome = CalculateUtils.calculateNetIncome(gradeAllowanceSalary, totalAmount);

                    return new EmployeeOutputDTO(
                            e.getId(),
                            e.getName(),
                            e.getDepartmentCode().description(),
                            e.getBasicSalaryCode(),
                            gradeAllowanceSalary,
                            familyAllowance,
                            nightAllowance,
                            totalAmount,
                            netIncome
                    );
                })
                .collect(Collectors.toList());
    }

}
