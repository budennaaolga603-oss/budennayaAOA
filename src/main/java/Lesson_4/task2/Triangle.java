package Lesson_4.task2;

public class Triangle implements Shape {

    private String name;
    private double a;
    private double b;
    private double c;
    private String fillColor;
    private String borderColor;

    public Triangle(String name, double a, double b, double c, String fillColor, String borderColor) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
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
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}