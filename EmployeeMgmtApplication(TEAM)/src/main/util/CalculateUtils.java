package main.util;

/**
 * 작성자 : 오찬근
 * 작성일 : 2024-08-01
 * 작성 목적 : 계산 로직을 담는 유틸 클래스
 * 작성 환경 : Windows 11, JDK 17, Intellij IDEA
 */
public class CalculateUtils {

    private CalculateUtils() {

    }

    public static int calculateGradeAllowanceSalary(int gradeAllowanceCode) {
        return switch (gradeAllowanceCode) {
            case 1 -> 900000;
            case 2 -> 400000;
            case 3 -> 600000;
            case 4, 6, 7 -> 800000;
            case 5 -> 300000;
            default -> 0;
        };
    }

    public static int calculateNightAllowance(int nightHours) {
        if (nightHours >= 1 && nightHours <= 4) {
            return nightHours * 1000 + 500;
        }

        return 0;
    }

    public static int calculateBasicSalary(int basicSalaryGrade) {
        if (basicSalaryGrade >= 1 && basicSalaryGrade <= 4) {
            return basicSalaryGrade * 10000 + 5000;
        }

        return 0;
    }

    public static int calculateFamilyAllowance(int numberOfFamilyMembers) {
        return numberOfFamilyMembers * 7000;
    }

    public static int calculateTotalAmount(int gradeAllowanceSalary, int basicSalary,
                                           int nightAllowance, int familyAllowance) {
        return gradeAllowanceSalary + basicSalary + nightAllowance + familyAllowance;
    }

    public static int calculateNetIncome(int gradeAllowanceSalary, int totalAmount) {
        return (int) (totalAmount - gradeAllowanceSalary * 0.1);
    }

}
