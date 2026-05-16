package Lesson_4.task2;

public class Main {

    public static void main(String[] args) {

        Shape circle    = new Circle("Круг", 5, "красный", "чёрный");
        Shape rectangle = new Rectangle("Прямоугольник", 4, 6, "синий", "белый");
        Shape triangle  = new Triangle("Треугольник", 3, 4, 5, "зелёный", "серый");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}