package _interface.drawing;

// 추상 클래스 정의
abstract class Shape {
    protected String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract double calculateArea();

    public void printColor() {
        System.out.println("Color: " + color);
    }
}
