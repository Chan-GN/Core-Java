package main;

import main.config.ApplicationFactory;
import main.view.EmployeeView;

/**
 * 작성자 : 오찬근
 * 작성일 : 2024-08-01
 * 작성 목적 : 메인 클래스
 * 작성 환경 : Windows 11, JDK 17, Intellij IDEA
 */
public class EmployeeMgmtApplication {

    public static void main(String[] args) {
        EmployeeView view = ApplicationFactory.createView();
        view.render();
    }

}
