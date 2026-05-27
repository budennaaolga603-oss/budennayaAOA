package Lesson_3;

public class HomeworkApp {

    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Apple iPhone 16 Pro", "15.09.2024", "Apple Inc.", "USA", 6299, false);
        productsArray[2] = new Product("Sony WH-1000XM5", "10.06.2024", "Sony Corporation", "Japan", 2499, true);
        productsArray[3] = new Product("Xiaomi Redmi Note 13", "20.03.2024", "Xiaomi Inc.", "China", 1399, false);
        productsArray[4] = new Product("Dyson V15 Detect", "05.11.2024", "Dyson Ltd.", "UK", 3799, false);

        for (Product p : productsArray) {
            p.printInfo();
        }

        Park park = new Park("Парк приключений", null);

        Park.Attraction[] attrs = new Park.Attraction[3];
        attrs[0] = park.new Attraction("Колесо обозрения", "10:00", "22:00", 300);
        attrs[1] = park.new Attraction("Американские горки", "11:00", "21:00", 500);
        attrs[2] = park.new Attraction("Карусель", "09:00", "20:00", 150);

        park.setAttractions(attrs);
        park.printInfo();
    }
}