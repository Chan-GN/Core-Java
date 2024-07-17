import java.io.IOException;
import java.io.InputStream;

public class IODemo {

    public static void main(String[] args) {
        System.out.print("글자 한 개를 입력하세요. : ");
        InputStream in = System.in;
        int code;
        try {
            code = in.read(); // ASCII 코드
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(code);
        System.out.println("code = " + (char) code);
    }

}
