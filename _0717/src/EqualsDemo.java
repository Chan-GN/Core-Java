/*
 * Object 의 equals 메서드는 다음과 같다.
 * public boolean equals(Object obj) {
 *     return (this == obj);
 * }
 * 즉, 재정의하지 않으면 == 연산자와 동일하게 동작한다. (참조 비교)
 */

import java.util.Objects;

public class EqualsDemo {

    public static void main(String[] args) {
        Point original = new Point(30, 100);
        Point target = new Point(30, 100);

        System.out.println(original.equals(target));
    }

}

class Point {

    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}