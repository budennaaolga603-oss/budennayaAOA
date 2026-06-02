package Lesson_6.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    // Ключ — фамилия, значение — список номеров
    private Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    // Метод добавления записи
    public void add(String lastName, String phoneNumber) {

        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new ArrayList<>());
        }
        phoneBook.get(lastName).add(phoneNumber);
    }

    // Метод поиска по фамилии
    public void get(String lastName) {
        if (phoneBook.containsKey(lastName)) {
            System.out.println(lastName + ": " + phoneBook.get(lastName));
        } else {
            System.out.println("Фамилия " + lastName + " не найдена");
        }
    }
}