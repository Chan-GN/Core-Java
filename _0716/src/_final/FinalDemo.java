package _final;

public class FinalDemo {

    public static void main(String[] args) {
        Parent parent = new Child();
        parent.display();
    }

}

class Parent {

    public void display() {
        System.out.println("나는 상위 클래스의 메서드");
    }

    public final void doSomething() {
        System.out.println("Can't Override this Method");
    }

}

class Child extends Parent {

    @Override
    public void display() {
        System.out.println("나는 하위 클래스의 메서드");
    }

}