package Lesson_6.task1;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StudentCollection collection = new StudentCollection();

        collection.add(new Student("Иванов",  "A1", 1, List.of(5, 4, 5)));
        collection.add(new Student("Петров",  "A1", 1, List.of(2, 2, 2)));
        collection.add(new Student("Сидоров", "B2", 2, List.of(4, 3, 4)));
        collection.add(new Student("Козлов",  "B2", 2, List.of(1, 2, 2)));
        collection.add(new Student("Смирнов", "C3", 3, List.of(5, 5, 4)));

        // Вывод всех студентов до отчисления
        System.out.println("Все студенты до отчисления:");
        for (Student s : collection.getStudents()) {
            System.out.println(s.getName() + " — средний балл: " + s.getAverageGrade());
        }

        // Удаление студентов
        collection.removeWeakStudents();

        System.out.println("\nПосле отчисления студентов:");
        for (Student s : collection.getStudents()) {
            System.out.println(s.getName());
        }

        // Перевод оставшихся на следующий курс
        collection.promoteStudents();

        System.out.println("\nСтуденты 2 курса после перевода:");
        collection.printStudents(2);

        System.out.println("\nСтуденты 3 курса после перевода:");
        collection.printStudents(3);
    }
}