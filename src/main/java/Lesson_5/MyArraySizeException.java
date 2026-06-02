package Lesson_5;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
        super("Размер массива должен быть 4х4");
    }
}