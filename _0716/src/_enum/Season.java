package _enum;

/**
 * @author Chan
 * @version 1
 * @since jdk 17
 */
public enum Season {

    SPRING(1), SUMMER(2), FALL(3), WINTER(4);

    private final int value;

    Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
