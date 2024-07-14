package team;

public class PayrollSystem {
    private static int getBaseSalary(int grade, int salaryClass) {
        if (grade == 1) {
            return 98_000 - (3_000 * salaryClass);
        }
        if (grade == 2) {
            return 85_000 - (5_000 * salaryClass);
        }
        return 0;
    }

    private static double getTaxRate(int totalSalary) {
        if (totalSalary >= 90_000) {
            return 0.012;
        }
        if (totalSalary >= 80_000) {
            return 0.007;
        }
        if (totalSalary >= 70_000) {
            return 0.005;
        }
        return 0;
    }

    private static int getAdjAmount(int totalSalary) {
        if (totalSalary >= 90_000) {
            return 1000;
        }
        if (totalSalary >= 80_000) {
            return 500;
        }
        if (totalSalary >= 70_000) {
            return 300;
        }
        return 0;
    }

    public void calculatePayroll(Employee[] employees) {
        for (Employee employee : employees) {
            if (employee == null) {
                return;
            }

            int baseSalary = getBaseSalary(employee.getGrade(), employee.getSalaryClass());
            employee.setBaseSalary(baseSalary);

            int totalSalary = baseSalary + employee.getExtraPay();
            employee.setTotalSalary(totalSalary);

            double taxRate = getTaxRate(totalSalary);
            employee.setTaxRate(taxRate);

            int adjAmount = getAdjAmount(totalSalary);
            employee.setAdjAmount(adjAmount);

            int tax = (int) (totalSalary * taxRate) - adjAmount;
            employee.setTax(tax);

            int netAmount = totalSalary - tax;
            employee.setNetAmount(netAmount);
        }
    }
}
