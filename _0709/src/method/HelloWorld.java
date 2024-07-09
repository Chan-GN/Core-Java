package method;

/**
 * Hello World!를 출력하는 방법들
 */
public class HelloWorld {
    static String str2 = "Hello World!"; // Class | Static Variable
    String str3 = "Hello World!"; // Instance Variable

    public static void main(String[] args) {
        String str1 = "Hello World!"; // Local | Stack | Temporary | Auto Variable
        System.out.println(str1);

        // System.out.println(method.HelloWorld.str2);
        System.out.println(str2); // 동일 클래스에 있는 클래스 변수는 클래스 이름 생략 가능

        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.str3);
        System.out.println(helloWorld.str2);

        System.out.println(Demo.str4);

        Demo demo = new Demo();
        System.out.println(demo.str5);

        // method.HelloWorld.printHelloWorld();
        printHelloWorldWithStatic();

        helloWorld.printHelloWorld();

        Demo.printHelloWorldWithStatic();

        demo.printHelloWorld();
    }

    static void printHelloWorldWithStatic() {
        String str6 = "Hello World!";
        System.out.println(str6);
    }

    void printHelloWorld() {
        String str7 = "Hello World!";
        System.out.println(str7);
    }
}

class Demo {
    static String str4 = "Hello World!";
    String str5 = "Hello World!";

    static void printHelloWorldWithStatic() {
        String str8 = "Hello World!";
        System.out.println(str8);
    }

    void printHelloWorld() {
        String str9 = "Hello World!";
        System.out.println(str9);
    }
}