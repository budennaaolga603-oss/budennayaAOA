package Lesson_7;

public class NumberComparator {

    public static int compare(int a, int b) {
        if (a > b) return 1;
        if (a < b) return -1;
        return 0;
    }

    public static boolean isEqual(int a, int b) {
        return a == b;
    }

    public static boolean isGreater(int a, int b) {
        return a > b;
    }

    public static boolean isLess(int a, int b) {
        return a < b;
    }
}