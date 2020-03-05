package Java1.Lesson7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("mr.Catty", 20);
        cats[1] = new Cat("Terminator", 40);
        cats[2] = new Cat("Pirate", 30);
        cats[3] = new Cat("Eagle", 10);
        cats[4] = new Cat("Boss", 5);

        for (Cat cat : cats) {
            cat.infoHungry();
            cat.eat(plate);
            cat.infoHungry();
            plate.info();
            System.out.println();
        }
        plate.putTheFood();
        plate.info();

    }
}
