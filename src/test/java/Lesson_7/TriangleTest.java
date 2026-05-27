package Lesson_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    void testAreaOfRightTriangle() {
        assertEquals(6.0, Triangle.getArea(3, 4, 5), 0.001);
    }

    @Test
    void testAreaOfEquilateralTriangle() {
        assertEquals(43.301, Triangle.getArea(10, 10, 10), 0.001);
    }

    @Test
    void testNegativeSideThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.getArea(-1, 4, 5));
    }

    @Test
    void testInvalidTriangleThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> Triangle.getArea(1, 2, 10));
    }
}