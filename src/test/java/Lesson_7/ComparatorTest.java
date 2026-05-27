package Lesson_7;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ComparatorTest {

    @Test
    public void testFirstIsGreater() {
        assertEquals(NumberComparator.compare(10, 5), 1);
    }

    @Test
    public void testFirstIsLess() {
        assertEquals(NumberComparator.compare(5, 10), -1);
    }

    @Test
    public void testEqual() {
        assertEquals(NumberComparator.compare(5, 5), 0);
    }

    @Test
    public void testIsEqual() {
        assertTrue(NumberComparator.isEqual(5, 5));
    }

    @Test
    public void testIsGreater() {
        assertTrue(NumberComparator.isGreater(10, 5));
    }

    @Test
    public void testIsLess() {
        assertTrue(NumberComparator.isLess(5, 10));
    }
}