package Lesson_4.task1;

public class Dog extends Animal {

    private static int dogCount = 0;
    private String name;

    public Dog(String name) {
        super();
        this.name = name;
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(name + " не может пробежать " + distance + " м. (максимум 500 м.)");
        } else {
            System.out.println(name + " пробежал " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(name + " не может проплыть " + distance + " м. (максимум 10 м.)");
        } else {
            System.out.println(name + " проплыл " + distance + " м.");
        }
    }
}