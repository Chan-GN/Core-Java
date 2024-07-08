public class Review {
    public static void main(String[] args) {
        // int -> byte  Explicit 형변환
        int i, b;
        i = 300;
        b = (byte) i; // i = 100101100 -> b = 00101100(앞의 1이 잘림)
        System.out.printf("[int -> byte] i = %d -> b = %d%n", i, b);

        // 유니코드, char 타입, 16진수 표현법
        char ch = 'A'; // char ch = 65; char ch1 = '\u0041';
        int code = (int) ch; // ch에 저장된 값을 int타입으로 변환하여 저장한다.

        System.out.printf("%c = %d(%#X)%n", ch, code, code); // %#X의 의미는?
    }
}
