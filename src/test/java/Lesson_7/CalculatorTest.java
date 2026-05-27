package Lesson_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void testAdd() {
        assertEquals(10, Calculator.add(3, 7));
    }

    @Test
    void testSubtract() {
        assertEquals(5, Calculator.subtract(10, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(12, Calculator.multiply(3, 4));
    }

    @Test
    void testDivide() {
        assertEquals(2.5, Calculator.divide(5, 2), 0.001);
    }

    @Test
    void testDivideByZeroThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.divide(5, 0));
    }
}