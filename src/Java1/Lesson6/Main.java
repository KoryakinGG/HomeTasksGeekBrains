package Java1.Lesson6;
import static Java1.Lesson6.Animal.count;

import static Java1.Lesson6.Animal.count;

public class Main {
    public static void main(String[] args) {
        Animal cat1 = new Cat();
        Animal dog1 = new Dog();
        Cat cat2 = new Cat();
        Dog dog2 = new Dog ();

        cat1.setName("Мурзик");
        cat1.run(150);
        cat1.swim(10);

        dog1.setName("Барбос");
        dog1.run(260);
        dog1.swim(20);

        cat2.setName("Пират");
        cat2.run(300);
        cat2.swim(10);

        dog2.setName("Киллер");
        dog2.run(501);
        dog2.swim(9);

        System.out.println("\nВсего создано животных на Земле "+ count);
    }
}
