package main.view;

import main.controller.InsertController;
import main.controller.SelectController;
import main.exception.EmployeeNotFoundException;
import main.model.EmployeeOutputDTO;

import java.util.List;

/**
 * 작성자 : 오찬근
 * 작성일 : 2024-08-01
 * 작성 목적 : View 클래스
 * 작성 환경 : Windows 11, JDK 17, Intellij IDEA
 */
public class EmployeeView {

    private final InsertController insertController;
    private final SelectController selectController;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public EmployeeView(InsertController insertController, SelectController selectController,
                        InputHandler inputHandler, OutputHandler outputHandler) {
        this.insertController = insertController;
        this.selectController = selectController;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void render() {
        boolean isContinue = true;
        while (isContinue) {
            switch (showMenu()) {
                case 1:
                    insertMenu();
                    break;
                case 2:
                    getOneMenu();
                    break;
                case 3:
                    getAllMenu();
                    break;
                case 9:
                    isContinue = false;
                    break;
                default:
                    System.out.println("잘못된 번호입니다.");
            }
        }

    }

    private int showMenu() {
        outputHandler.displayMenu();

        return inputHandler.getIntInput("번호 입력 : ");
    }

    private void insertMenu() {
        do {
            insertEmployee();
        } while (inputHandler.getIOInput("사원 등록을 계속하시겠습니까? (I / O) : "));
    }

    private void getOneMenu() {
        String id = inputHandler.getStringInput("사원 번호를 입력해주세요. : ");
        try {
            EmployeeOutputDTO employee = selectController.getEmployeeById(id);

            outputHandler.displayOneEmployee(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getAllMenu() {
        List<EmployeeOutputDTO> allEmployees = selectController.getAllEmployees();
        outputHandler.displayAllEmployees(allEmployees);
    }

    private void insertEmployee() {
        String id = inputHandler.getStringInput("사원 번호 : ");
        String name = inputHandler.getStringInput("사원 이름 : ");
        int basicSalaryGrade = inputHandler.getIntInput("기본급 : ");
        int nightHours = inputHandler.getIntInput("야간 시간 : ");
        int numberOfFamilyMembers = inputHandler.getIntInput("가족수 : ");

        boolean result = insertController.saveEmployee(id, name, basicSalaryGrade, nightHours, numberOfFamilyMembers);
    }

}
