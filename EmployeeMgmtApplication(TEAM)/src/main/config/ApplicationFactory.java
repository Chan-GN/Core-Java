package main.config;

import main.controller.InsertController;
import main.controller.SelectController;
import main.model.EmployeeDAO;
import main.model.EmployeeDAOImpl;
import main.view.EmployeeView;
import main.view.InputHandler;
import main.view.OutputHandler;

/**
 * 작성자 : 오찬근
 * 작성일 : 2024-08-01
 * 작성 목적 : View 생성 클래스
 * 작성 환경 : Windows 11, JDK 17, Intellij IDEA
 */
public class ApplicationFactory {

    public static EmployeeView createView() {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        InsertController insertController = new InsertController(employeeDAO);
        SelectController selectController = new SelectController(employeeDAO);
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        return new EmployeeView(insertController, selectController, inputHandler, outputHandler);
    }

}
