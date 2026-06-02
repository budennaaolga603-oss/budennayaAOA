package Lesson_2;

public class HomeworkApp {

    // ===== ЗАДАНИЕ 1 =====
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    // ===== ЗАДАНИЕ 2 =====
    public static void checkSumSign() {
        int a = -15;
        int b = -9;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    // ===== ЗАДАНИЕ 3 =====
    public static void printColor() {
        int value = 578;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // ===== ЗАДАНИЕ 4 =====
    public static void compareNumbers() {
        int a = 7;
        int b = -9;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    // ===== ЗАДАНИЕ 5 =====
    public static boolean sumBetween(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    // ===== ЗАДАНИЕ 6 =====
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    // ===== ЗАДАНИЕ 7 =====
    public static boolean trueFalseNumber(int number) {
        return number < 0;
    }

    // ===== ЗАДАНИЕ 8 =====
    public static void repeatString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    // ===== ЗАДАНИЕ 9 =====
    public static boolean leapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    // ===== ЗАДАНИЕ 10 =====
    public static void invertArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i]= 1 - arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ===== ЗАДАНИЕ 11 =====
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        // печать массива вручную
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ===== ЗАДАНИЕ 12 =====
    public static void lessThan6() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // ===== ЗАДАНИЕ 13 =====
    public static void createDiagonal() {
        int size = 5;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ===== ЗАДАНИЕ 14 =====
    public static int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }


    public static void main(String[] args) {
        printThreeWords();                                  //1 задание
        checkSumSign();                                     //2 задание
        printColor();                                       //3 задание
        compareNumbers();                                   //4 задание
        System.out.println(sumBetween(45,5));         //5 задание
        checkNumber(0);                                     //6 задание
        System.out.println(trueFalseNumber(-76));           //7 задание
        repeatString("Демогоргон", 3);            //8 задание
        System.out.println(leapYear(2028));                 //9 задание
        invertArray();                                      //10 задание
        fillArray();                                        //11 задание
        lessThan6();                                        //12 задание
        createDiagonal();                                   //13 задание
        int[] myArray = createArray(9, 100);  //14 задание
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }
}










