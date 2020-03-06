package Java1.Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry;

    protected Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true;
    }

    protected void eat(Plate plate) {
        System.out.println("Cat " + name + " eating...");
        if (hungry && plate.decreaseFood(appetite)) {
            hungry = false;
        }
    }

    protected void infoHungry() {
        String isHungry = hungry ? "hungry" : "not hungry";
        System.out.println(name + ": " + isHungry);
    }
}
