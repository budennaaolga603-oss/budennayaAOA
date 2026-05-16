package Lesson_4.task2;

public class Rectangle implements Shape {

    private String name;
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(String name, double width, double height, String fillColor, String borderColor) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
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