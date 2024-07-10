package method;

public class VarargsDemo {
    public static void main(String[] args) {
        new VarargsDemo().printAll(1, 2, 3, 4, 5); // Argument, 인자

        int a = 5;
        char b = 'B';
        boolean c = true;
        double avg = 58.6;
        String name = "백예린";

        new VarargsDemo().printAll(a, b, c, avg, name);
    }

    /*
     * 타입 안정성이 부족하여 좋은 방식이 아님
     * 추후 배울 제네릭을 사용하는 것이 바람직함
     */
    void printAll(Object... arr) { // Parameter, 매개변수
        for (Object a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}