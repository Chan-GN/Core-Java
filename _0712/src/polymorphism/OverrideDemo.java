package polymorphism;

import java.util.Scanner;

public class OverrideDemo {
    public static void main(String[] args) {
        Base base = new Derived();
        base.display();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}

/*
 * Override 된 자식 메서드의 접근 범위는 부모 메서드보다 같거나 더 넓어야한다.
 */
class Base {
    protected void display() {
        System.out.println("나는 수퍼 클래스의 메서드");
    }
}

class Derived extends Base {
    @Override
    public void display() {
        System.out.println("나는 서브 클래스의 메서드");
    }
}