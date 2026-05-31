package Lesson_4.task2;

public class Triangle implements Shape {

    private String name;
    private double a;
    private double b;
    private double c;
    private Color color;

    public Triangle(String name, double a, double b, double c, Color color) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.color = color;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
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