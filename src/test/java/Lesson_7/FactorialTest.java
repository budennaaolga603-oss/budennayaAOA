package Lesson_7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.calculate(0), 1);
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(Factorial.calculate(1), 1);
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(Factorial.calculate(5), 120);
    }

    @Test
    public void testFactorialOfTen() {
        assertEquals(Factorial.calculate(10), 3628800);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeThrowsException() {
        Factorial.calculate(-1);
    }
}