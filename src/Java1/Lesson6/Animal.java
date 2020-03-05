package Java1.Lesson6;

public abstract class Animal {
    private String name;
    static int count = 0;
    public Animal (String name){
        this.name = name;
        count++;
    }
//    Animal () {count++;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run (int distance){
        System.out.format("%s пробежал %d метров \n", getName(), distance);
    }

    public void swim (int distance) {
        System.out.format("%s проплыл %d метров \n", getName(), distance);
    }

}