package oop;

public class ThisDemo2 {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        System.out.println(emp1.getEmpId());
        System.out.printf("%f%n", emp1.getSalary());

        Employee emp2 = new Employee("사번 1");
        System.out.println(emp2.getEmpId());
        System.out.printf("%f%n", emp2.getSalary());
    }
}
