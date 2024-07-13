package polymorphism;

public class PolymorphismDemo2 {
    public static void main(String[] args) {
        String str = "Some String";
        Object obj = str;
        String target = (String) obj;

        System.out.println(target);

        Super s = new Super();
        Sub sub = new Sub();

        s = sub;
        s.display();
    }
}

class Super {
    public void display() {
        System.out.println("나는 부모 메서드");
    }
}

class Sub extends Super {
    @Override
    public void display() {
        System.out.println("나는 자식 메서드");
    }
}