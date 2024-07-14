package my;

public class PayrollApplication {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        PayrollSystem payrollSystem = new PayrollSystem();
        OutputHandler outputHandler = new OutputHandler();

        Employee[] employees = inputHandler.getEmployees();
        payrollSystem.calculatePayroll(employees);
        outputHandler.printEmployeesInfo(employees);
    }
}
