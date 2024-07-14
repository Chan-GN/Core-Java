package my;

public class PayrollSystem {
    public void calculatePayroll(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            employee.getSalary().calculate(employee.getGrade(), employee.getSalaryClass());
        }
    }
}
