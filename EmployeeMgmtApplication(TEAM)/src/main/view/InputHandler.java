package main.view;

import java.util.Scanner;

/**
 * 작성자 : 오찬근
 * 작성일 : 2024-08-01
 * 작성 목적 : 입력을 담당하는 클래스
 * 작성 환경 : Windows 11, JDK 17, Intellij IDEA
 */
public class InputHandler {

    private final Scanner scanner = new Scanner(System.in);

    public int getIntInput(String prompt) {
        System.out.print(prompt);

        return scanner.nextInt();
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt);

        return scanner.next();
    }

    public boolean getIOInput(String prompt) {
        while (true) {
            String input = getStringInput(prompt).trim().toLowerCase();
            if (input.equals("i")) return true;
            if (input.equals("o")) return false;
            System.out.println("잘못된 입력입니다. I 또는 O을 입력해주세요.");
        }
    }

}
