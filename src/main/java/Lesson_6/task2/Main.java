package Lesson_6.task2;

public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "9-999-555-22-77");
        phoneBook.add("Иванов", "7-777-555-22-77");
        phoneBook.add("Иванов", "8-888-555-22-77");
        phoneBook.add("Петров", "9-111-222-33-44");
        phoneBook.add("Сидоров", "9-555-666-77-88");
        phoneBook.add("Андреев", "8-800-555-35-35");


        phoneBook.get("Иванов");
        phoneBook.get("Петров");
        phoneBook.get("Андреев");
        phoneBook.get("Козлов");
    }
}