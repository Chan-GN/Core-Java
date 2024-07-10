package method;

import java.util.Scanner;

public class Input {
    void input(Student std) {
        Scanner sc = new Scanner(System.in);
        System.out.print("학번 : ");
        std.setStuId(sc.nextLine().trim());
        System.out.print("이름 : ");
        std.setName(sc.nextLine().trim());
        System.out.print("국어 : ");
        std.setKor(sc.nextInt());
        System.out.print("영어 : ");
        std.setEng(sc.nextInt());
        System.out.print("수학 : ");
        std.setMath(sc.nextInt());
    }
}
