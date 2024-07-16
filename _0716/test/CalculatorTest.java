import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void test() {
        assertNotNull(calculator);
    }

    @Test
    void add() {
        assertEquals(8, calculator.add(5, 3), "5 + 3 should equal 8");
    }

    @Test
    void subtract() {
        assertEquals(2, calculator.subtract(5, 3), "5 - 3 should equal 2");
    }

    @Test
    void multiply() {
        assertEquals(15, calculator.multiply(5, 3), "5 * 3 should equal 15");
    }

    @Test
    void divide() {
        assertEquals(2., calculator.divide(6, 3), "6 / 3 should equal 2");
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0),
                "Dividing by zero should throw ArithmeticException");
    }

}