package my;

import java.util.Scanner;

public class InputHandler {
    public Employee[] getEmployees() {
        Employee[] employees = new Employee[5];
        Scanner sc = new Scanner(System.in);

        String i_o;
        for (int i = 0; i < 5; i++) {
            System.out.print("사원번호 : ");
            int empId = sc.nextInt();
            System.out.print("급 : ");
            int grade = sc.nextInt();
            System.out.print("호 : ");
            int salaryClass = sc.nextInt();
            System.out.print("수당 : ");
            int extraPay = sc.nextInt();
            employees[i] = new Employee(empId, grade, salaryClass, extraPay);

            System.out.print("입력/출력(I/O)? ");
            i_o = sc.next();
            if (!i_o.equalsIgnoreCase("i")) {
                break;
            }
        }
        return employees;
    }
}
