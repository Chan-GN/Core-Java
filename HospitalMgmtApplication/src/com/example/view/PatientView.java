package com.example.view;

import com.example.controller.DeleteController;
import com.example.controller.InsertController;
import com.example.controller.SelectController;
import com.example.controller.UpdateController;
import com.example.exception.ApplicationException;
import com.example.model.MedicalDepartment;
import com.example.model.PatientDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PatientView {

    private final InsertController insertController;
    private final DeleteController deleteController;
    private final SelectController selectController;
    private final UpdateController updateController;
    private final InputHandler inputHandler;

    public PatientView(InsertController insertController, DeleteController deleteController, SelectController selectController, UpdateController updateController) {
        this.insertController = insertController;
        this.deleteController = deleteController;
        this.selectController = selectController;
        this.updateController = updateController;
        this.inputHandler = new InputHandler();
    }

    private static void displayPatientList(List<PatientDTO> patients) {
        System.out.println("--------------------- 환  자  목  록 ---------------------");
        System.out.printf("%-8s %-10s %-10s %-10s %-10s\n", "번호", "진찰부서", "진찰비", "입원비", "진료비");
        patients.forEach(System.out::println);
    }

    private static void displayPatientInfo(PatientDTO patient) {
        System.out.println("--------------------- 환  자  정  보 ---------------------");
        System.out.printf("%-8s %-10s %-10s %-10s %-10s\n", "번호", "진찰부서", "진찰비", "입원비", "진료비");
        System.out.println(patient);
    }

    public void render() {
        boolean isContinue = true;
        while (isContinue) {
            switch (showMenu()) {
                case 1:
                    insertMenu();
                    break;
                case 2:
                    readOneMenu();
                    break;
                case 3:
                    readAllMenu();
                    break;
                case 4:
                    updateMenu();
                    break;
                case 5:
                    deleteMenu();
                    break;
                case 99:
                    isContinue = false;
                    break;
                default:
                    System.out.println("잘못된 번호입니다.");
            }
        }
    }

    private void updateMenu() {
        int patientNumber = inputHandler.getIntInput("갱신할 환자의 번호를 입력해주세요: ");

        try {
            PatientDTO patient = selectController.readOnePatient(patientNumber);
            displayPatientInfo(patient);

            Map<String, Object> updates = new HashMap<>();
            boolean isUpdated = false;

            // 진료 코드 수정
            if (inputHandler.getYesNoInput("진료 코드를 수정하시겠습니까? (Y/N): ")) {
                String newCode = inputHandler.getStringInput("새로운 진료 코드를 입력해주세요: ").toUpperCase();
                try {
                    MedicalDepartment newDepartment = MedicalDepartment.valueOf(newCode);
                    updates.put("treatmentCode", newDepartment);
                    isUpdated = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(newCode + "는 유효하지 않은 진료 코드입니다.");
                }
            }

            // 입원 일수 수정
            if (inputHandler.getYesNoInput("입원 일수를 수정하시겠습니까? (Y/N): ")) {
                int newDays = inputHandler.getIntInput("새로운 입원 일수를 입력해주세요: ");
                updates.put("lengthOfStay", newDays);
                isUpdated = true;
            }

            // 나이 수정
            if (inputHandler.getYesNoInput("나이를 수정하시겠습니까? (Y/N): ")) {
                int newAge = inputHandler.getIntInput("새로운 나이를 입력해주세요: ");
                updates.put("age", newAge);
                isUpdated = true;
            }

            if (isUpdated) {
                try {
                    boolean result = updateController.updatePatient(patient, updates);
                    if (result) {
                        System.out.println("환자 정보가 성공적으로 업데이트되었습니다.");
                        PatientDTO updatedPatient = selectController.readOnePatient(patientNumber);
                        displayPatientInfo(updatedPatient);
                    } else {
                        System.out.println("환자 정보 업데이트에 실패했습니다.");
                    }
                } catch (ApplicationException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("변경된 정보가 없어 업데이트를 진행하지 않았습니다.");
            }

        } catch (ApplicationException e) {
            System.out.println("해당 번호의 환자가 존재하지 않습니다: " + patientNumber);
        }
    }

    private void readOneMenu() {
        int number = inputHandler.getIntInput("환자 번호를 입력해주세요. : ");
        try {
            PatientDTO patient = selectController.readOnePatient(number);
            displayPatientInfo(patient);
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteMenu() {
        try {
            List<PatientDTO> allPatients = selectController.readAllPatients();
            if (allPatients.isEmpty()) {
                System.out.println("등록된 환자가 없습니다.");
                return;
            } else {
                displayPatientList(allPatients);
            }
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        }

        int n = inputHandler.getIntInput("삭제하고 싶은 환자의 번호를 입력해주세요 : ");

        boolean result = deleteController.deletePatient(n);

        if (result) System.out.println(n + "번 환자의 정보를 삭제하였습니다.");
        else System.out.println("삭제 실패하였습니다. 환자 번호를 다시 확인해주세요.");
    }

    private void readAllMenu() {
        try {
            List<PatientDTO> patients = selectController.readAllPatients();
            if (patients.isEmpty()) {
                System.out.println("등록된 환자가 없습니다.");
            } else {
                displayPatientList(patients);
            }
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
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

        return inputHandler.getIntInput("번 호  입 력 : ");
    }

    private void insertMenu() {
        boolean continueInserting;
        do {
            System.out.println("환자 등록 메뉴");
            int number = inputHandler.getIntInput("등록 번호 : ");
            String code = inputHandler.getStringInput("진료 코드 : ").toUpperCase();
            int day = inputHandler.getIntInput("입원 일수 : ");
            int age = inputHandler.getIntInput("나    이 : ");

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
                MedicalDepartment department = MedicalDepartment.valueOf(code);
                PatientDTO patientDTO =
                        new PatientDTO(number, department, day, age);
                boolean result = insertController.insert(patientDTO);

                if (result) System.out.println("입력에 성공하였습니다.");
                else {
                    System.out.println("입력에 실패하였습니다.");
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(code + "는 유효하지 않은 진료 코드입니다.");
            }

            continueInserting = inputHandler.getYesNoInput("환자 등록을 계속하시겠습니까? (Y/N) : ");
        } while (continueInserting);
    }

    private static class InputHandler {

        private final Scanner scanner = new Scanner(System.in);

        public int getIntInput(String prompt) {
            System.out.print(prompt);
            return scanner.nextInt();
        }

        public String getStringInput(String prompt) {
            System.out.print(prompt);
            return scanner.next();
        }

        public boolean getYesNoInput(String prompt) {
            while (true) {
                String input = getStringInput(prompt).trim().toLowerCase();
                if (input.equals("y")) return true;
                if (input.equals("n")) return false;
                System.out.println("잘못된 입력입니다. Y 또는 N을 입력해주세요.");
            }
        }

    }

}


