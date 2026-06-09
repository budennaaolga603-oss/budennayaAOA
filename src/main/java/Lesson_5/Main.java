package Lesson_5;

public class Main {

    public static void main(String[] args) {

        //Корректный
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        //Неверный размер
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        //Неверные данные
        String[][] wrongDataArray = {
                {"1",  "2",  "3",   "4"},
                {"5",  "abc", "7",  "8"},
                {"9",  "10", "11",  "12"},
                {"13", "14", "15",  "16"}
        };

        try {
            int result = ArrayProcessor.processArray(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        try {
            int result = ArrayProcessor.processArray(wrongSizeArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
        }

        try {
            int result = ArrayProcessor.processArray(wrongDataArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.err.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println("Ошибка данных: " + e.getMessage());
        }

        //Поимка ArrayIndexOutOfBoundsException
        System.out.println();
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Ошибка ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}