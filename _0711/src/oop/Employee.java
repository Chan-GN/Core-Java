package oop;

public class Employee {
    private String empId;
    private double salary;

    public Employee() {
        // System.out.println("Do Something"); // Error
        this("Undefined", 10_000_000);
    }

    public Employee(String empId) {
        this(empId, 10_000_000);
    }

    public Employee(double salary) {
        this("Undefined", salary);
    }

    public Employee(String empId, double salary) {
        this.empId = empId;
        this.salary = salary;
    }

    public String getEmpId() {
        return empId;
    }

    public double getSalary() {
        return salary;
    }
}
