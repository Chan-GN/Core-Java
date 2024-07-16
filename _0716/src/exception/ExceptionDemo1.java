package exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionDemo1 {

    public static void main(String[] args) {
        String str = null;
        // System.out.println(str.length()); // NullPointerException
        assert str != null;
        try {
            System.out.println(str.length());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("e.getMessage()");
            System.out.println(e.getMessage());
            System.out.println("e.toString()");
            System.out.println(e);
            System.out.println("e.printStackTrace()");
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    /*
        String money = "3000원";
        System.out.println(Integer.parseInt(money)); // NumberFormatException
    */

    /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력하세요. : ");
        System.out.println(scanner.nextInt()); // 정수를 입력하지 않는다면, InputMismatchException
    */

    /*
        int[] array = {1, 2, 3, 4};
        for (int i = 0; i <= 4; i++) {
            System.out.println(array[i]); // ArrayIndexOutOfBoundsException
        }
    */

        // int[] arr = new int[-3]; // NegativeArraySizeException

        try {
            new Scanner(new File("ExceptionDemo.java"));
        } catch (FileNotFoundException e) { // Checked Exception
            throw new RuntimeException(e);
        }
    }

}
