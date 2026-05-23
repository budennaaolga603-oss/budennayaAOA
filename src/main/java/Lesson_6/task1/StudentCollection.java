package Lesson_6.task1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class StudentCollection {

    private Set<Student> students = new HashSet<>();

    public void add(Student student) {
        students.add(student);
    }

    public Set<Student> getStudents() {
        return students;
    }

    // Метод удаления слабых студентов
    public void removeWeakStudents() {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                iterator.remove();
            }
        }
    }

    // Метод перевода студентов на следующий курс
    public void promoteStudents() {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    //Получить список студентов и номер курса
    public void printStudents(int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}