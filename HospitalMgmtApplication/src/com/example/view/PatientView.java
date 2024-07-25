package com.example.view;

import com.example.controller.InsertController;
import com.example.model.MedicalDepartment;
import com.example.model.PatientDTO;

import java.util.Scanner;

public class PatientView {

    private final InsertController insertController;
    private final Scanner scanner;

    public PatientView(InsertController insertController) {
        this.insertController = insertController;
        this.scanner = new Scanner(System.in);
    }

    public void render() {
        boolean isContinue = true;
        while (isContinue) {
            switch (showMenu()) {
                case 1:
                    insertMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 99:
                    isContinue = false;
                    break;
                default:
                    System.out.println("잘못된 번호입니다.");
            }
        }
    }

    private int showMenu() {
        System.out.println("----------------------------");
        System.out.println(" Patient Management Program ");
        System.out.println("----------------------------");

        System.out.println("1. 환자 등록");
        System.out.println("2. 환자 검색");
        System.out.println("3. 환자 목록");
        System.out.println("4. 환자 수정");
        System.out.println("5. 환자 삭제");
        System.out.println("99. 종   료");

        System.out.println("----------------------------");
        System.out.print("번 호  입 력 : ");

        return scanner.nextInt();
    }

    private void insertMenu() {
        System.out.println("환자 등록 메뉴");
        System.out.print("등록 번호 : ");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.print("진료 코드 : ");
        String code = scanner.nextLine().toUpperCase();
        System.out.print("입원 일수 : ");
        int day = scanner.nextInt();
        System.out.print("나    이 : ");
        int age = scanner.nextInt();

    /*
        // Stream-based approach
        MedicalDepartment department = Arrays.stream(MedicalDepartment.values())
                .filter(dep -> dep.name().equalsIgnoreCase(code))
                .findFirst()
                .orElse(MedicalDepartment.DEFAULT);
        PatientDTO patientDTO = new PatientDTO(number, department, day, age);
    */

        // Try-catch approach
        try {
            PatientDTO patientDTO = new PatientDTO(number, MedicalDepartment.valueOf(code), day, age);
            boolean result = insertController.insert(patientDTO);

            if (result) System.out.println("입력에 성공하였습니다.");
            else System.out.println("입력에 실패하였습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(code + "는 유효하지 않은 진료 코드입니다.");
        }
    }

}


