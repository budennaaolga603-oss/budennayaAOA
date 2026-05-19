package Lesson_4.task2;

public class Rectangle implements Shape {

    private String name;
    private double width;
    private double height;
    private Color color;

    public Rectangle(String name, double width, double height, Color color) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.color = color;
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
        return color.getFillColor();
    }

    @Override
    public String getBorderColor() {
        return color.getBorderColor();
    }
}