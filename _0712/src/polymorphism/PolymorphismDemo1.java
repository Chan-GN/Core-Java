package polymorphism;

/*
 * Polymorphism
 * 상속을 통한 다형성(객체 형변환)
 *  - 자동 형변환 - 자식 객체가 부모 객체로 형변환
 *  - 강제 형변환 - 부모 객체가 자식 객체로 형변환
 */
public class PolymorphismDemo1 {
    public static void main(String[] args) {
        Test test = new Test();
        Demo demo = new Demo();

        test = demo; // Implicit Conversion
        test = (Test) demo; // Explicit Conversion

        // demo = test; // Error
        if (test instanceof Demo) {
            demo = (Demo) test; // Explicit Conversion
        } else System.out.println("Cant conversion");
    }
}

class Test {

}

class Demo extends Test {

}