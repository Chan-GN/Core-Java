package main.model;

import java.util.List;

/**
 * 작성자: 이요한
 * 작성일: 2024-08-01
 * 작성 목적
 * - 데이터베이스 operation을 위한 메서드 설계
 */
public interface EmployeeDAO {

    boolean save(EmployeeDTO employeeDTO);

    List<EmployeeDTO> findAll();

}
