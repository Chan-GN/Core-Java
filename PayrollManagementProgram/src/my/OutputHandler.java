package my;

public class OutputHandler {
    void printEmployeesInfo(Employee[] employees) {
        System.out.println("                     <<급여관리프로그램>>");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-6s %-6s %-3s %-7s %-8s %-7s %-12s%n",
                "사번", "급수", "호", "수당", "지급액", "세금", "차인지급액");
        System.out.println("------------------------------------------------------------");

        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.println(employee.getBasicInfo() + " " + employee.getSalaryInfo());
        }
        System.out.println("------------------------------------------------------------");
        System.out.println();
        System.out.println("입력데이타 출력");
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            }
            System.out.println(employee.getInputDataInfo());
        }
    }
}
