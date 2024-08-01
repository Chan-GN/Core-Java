package main.controller;

import main.model.DepartmentCode;
import main.model.EmployeeDAO;
import main.model.EmployeeDTO;

/**
 * 작성자 : 오찬근
 * 작성일 : 2024-08-01
 * 작성 목적 : Insert 담당 컨트롤러
 * 작성 환경 : Windows 11, JDK 17, Intellij IDEA
 */
public class InsertController {

    private final EmployeeDAO employeeDAO;

    public InsertController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public boolean saveEmployee(String id, String name, int basicSalaryGrade, int nightHours, int numberOfFamilyMembers) {
        String departmentCode = id.substring(0, 1);
        int gradeAllowanceCode = Integer.parseInt(id.substring(1, 2));

        EmployeeDTO employeeDTO = new EmployeeDTO(id, name, basicSalaryGrade, nightHours, numberOfFamilyMembers,
                DepartmentCode.valueOf(departmentCode), gradeAllowanceCode);

        return employeeDAO.save(employeeDTO);
    }

}
