package Lesson_4.task1;

public class Bowl {

    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void addFood(int amount) {
        food += amount;
        System.out.println("В миску добавлено " + amount + " ед. еды. Итого: " + food);
    }

    public void takeFood(int amount) {
        food -= amount;
    }
}