package Lesson_7;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComparatorTest {

    @Test
    void testFirstIsGreater() {
        assertEquals(1, NumberComparator.compare(10, 5));
    }

    @Test
    void testFirstIsLess() {
        assertEquals(-1, NumberComparator.compare(5, 10));
    }

    @Test
    void testEqual() {
        assertEquals(0, NumberComparator.compare(5, 5));
    }

    @Test
    void testIsEqual() {
        assertTrue(NumberComparator.isEqual(5, 5));
    }

    @Test
    void testIsGreater() {
        assertTrue(NumberComparator.isGreater(10, 5));
    }

    @Test
    void testIsLess() {
        assertTrue(NumberComparator.isLess(5, 10));
    }
}