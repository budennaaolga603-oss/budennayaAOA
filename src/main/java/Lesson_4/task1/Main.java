package Lesson_4.task1;

public class Main {

    public static void main(String[] args) {

        Dog dogBobik = new Dog("Бобик");
        Dog dogRex = new Dog("Рекс");
        Cat catMurka = new Cat("Мурка");
        Cat catBarsik = new Cat("Барсик");
        Cat catTimoha = new Cat("Тимоха");

        dogBobik.run(150);
        dogRex.run(600);
        dogBobik.swim(8);
        dogRex.swim(15);

        catMurka.run(100);
        catBarsik.run(300);
        catTimoha.swim(5);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Всего собак:    " + Dog.getDogCount());
        System.out.println("Всего котов:    " + Cat.getCatCount());
        System.out.println();

        Bowl bowl = new Bowl(25);
        Cat[] cats = { catMurka, catBarsik, catTimoha };

        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }

        System.out.println();
        System.out.println("Осталось еды в миске: " + bowl.getFood());
        System.out.println();

        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " + (cat.isFull() ? "сыт" : "голоден"));
        }

        System.out.println();
        bowl.addFood(20);
    }
}