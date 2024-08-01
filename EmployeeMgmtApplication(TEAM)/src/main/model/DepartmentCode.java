package main.model;

/**
 * 작성자 : 오찬근
 * 작성일 : 2024-08-01
 * 작성 목적 : 사원 부서 Enum 클래스 코드(부서 이름)
 * 작성 환경 : Windows 11, JDK 17, Intellij IDEA
 */
public enum DepartmentCode {
    A("영업부"),
    B("업무부"),
    C("홍보부"),
    D("인사부"),
    E("경리부"),
    F("판촉부"),
    G("총부무");

    private final String departmentName;

    DepartmentCode(String departmentName) {
        this.departmentName = departmentName;
    }

    public String description() {
        return departmentName;
    }
}
