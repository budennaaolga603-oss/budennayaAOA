package Lesson_3;

public class Park {
    private String parkName;
    private Attraction[] attractions;

    public class Attraction {
        private String attractionName;
        private String openTime;
        private String closeTime;
        private double ticketPrice;

        public Attraction(String attractionName, String openTime,
                          String closeTime, double ticketPrice) {
            this.attractionName = attractionName;
            this.openTime = openTime;
            this.closeTime = closeTime;
            this.ticketPrice = ticketPrice;
        }

        public void printInfo() {
            System.out.println("Аттракцион: " + attractionName);
            System.out.println("Работает: " + openTime + " – " + closeTime);
            System.out.println("Стоимость: " + ticketPrice + " руб.");
            System.out.println();
        }
    }

    public Park(String parkName, Attraction[] attractions) {
        this.parkName = parkName;
        this.attractions = attractions;
    }

    public void setAttractions(Attraction[] attractions) {
        this.attractions = attractions;
    }

    public void printInfo() {
        System.out.println("Парк: " + parkName);
        System.out.println("Аттракционы:");
        for (Attraction a : attractions) {
            a.printInfo();
        }
    }
}
