package main.view;

import main.model.EmployeeOutputDTO;

import java.util.Comparator;
import java.util.List;

/**
 * 작성자 : 오찬근
 * 작성일 : 2024-08-01
 * 작성 목적 : 출력을 담당하는 클래스
 * 작성 환경 : Windows 11, JDK 17, Intellij IDEA
 */
public class OutputHandler {

    public void displayInit() {
        System.out.println("------------------------------");
        System.out.println(" Employee Management Program ");
        System.out.println("------------------------------");
    }

    public void displayAllEmployees(List<EmployeeOutputDTO> allEmployees) {
        System.out.printf("%-8s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s\n", "사원 번호", "사원 이름", "부서명",
                "기본급", "호급 수당", "가족 수당", "야간 수당", "총 금액", "실수령액");

        allEmployees.stream()
                .sorted(Comparator.comparing(EmployeeOutputDTO::getId))
                .forEach(System.out::println);
    }

}
