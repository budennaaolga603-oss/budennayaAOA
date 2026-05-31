package Lesson_7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        assertEquals(Calculator.add(3, 7), 10);
    }

    @Test
    public void testSubtract() {
        assertEquals(Calculator.subtract(10, 5), 5);
    }

    @Test
    public void testMultiply() {
        assertEquals(Calculator.multiply(3, 4), 12);
    }

    @Test
    public void testDivide() {
        assertEquals(Calculator.divide(5, 2), 2.5, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZeroThrowsException() {
        Calculator.divide(5, 0);
    }
}