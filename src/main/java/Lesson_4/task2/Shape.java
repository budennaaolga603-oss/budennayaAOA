package Lesson_4.task2;

public interface Shape {

    String getName();
    String getFillColor();
    String getBorderColor();
    double getArea();
    double getPerimeter();

    default void printInfo() {
        System.out.println("Фигура:       " + getName());
        System.out.println("Периметр:     " + String.format("%.2f", getPerimeter()));
        System.out.println("Площадь:      " + String.format("%.2f", getArea()));
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }
}