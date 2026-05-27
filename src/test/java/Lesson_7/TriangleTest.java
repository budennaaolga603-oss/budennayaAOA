package Lesson_7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleTest {

    @Test
    public void testAreaOfRightTriangle() {
        assertEquals(Triangle.getArea(3, 4, 5), 6.0, 0.001);
    }

    @Test
    public void testAreaOfEquilateralTriangle() {
        assertEquals(Triangle.getArea(10, 10, 10), 43.301, 0.001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeSideThrowsException() {
        Triangle.getArea(-1, 4, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTriangleThrowsException() {
        Triangle.getArea(1, 2, 10);
    }
}