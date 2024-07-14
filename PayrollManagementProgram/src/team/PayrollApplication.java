package team;

public class PayrollApplication {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        Employee[] employees = inputHandler.getEmployees();
        payrollSystem.calculatePayroll(employees);
        outputHandler.printEmployeesInfo(employees);
    }
}
