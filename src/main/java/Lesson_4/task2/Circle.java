package Lesson_4.task2;

public class Circle implements Shape {

    private String name;
    private double radius;
    private Color color;

    public Circle(String name, double radius, Color color) {
        this.name = name;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getFillColor() {
        return color.getFillColor();
    }

    @Override
    public String getBorderColor() {
        return color.getBorderColor();
    }
}