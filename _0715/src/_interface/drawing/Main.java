package _interface.drawing;

// 메인 클래스
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Red", 5.0);
        Rectangle rectangle = new Rectangle("Blue", 4.0, 6.0);

        // Shape의 메서드 사용
        System.out.println("Circle Area: " + circle.calculateArea());
        circle.printColor();

        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        rectangle.printColor();

        // Drawable의 메서드 사용
        circle.display();
        rectangle.display();
    }
}