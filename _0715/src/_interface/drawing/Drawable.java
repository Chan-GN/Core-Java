package _interface.drawing;

// 인터페이스 정의
interface Drawable {
    void draw();

    default void display() {
        System.out.println("Displaying the shape");
        draw();
    }
}



