package Java1.Lesson6;

public class Dog extends Animal {

//    public Dog(String name) {
//        super(name);
//    }


    public Dog(String name) {
        super(name);
    }


    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.format("%s устал(а) и отдыхает\n", getName());
        }
    }

    @Override
    public void swim(int distance) {
        if (distance < 10) {
            super.swim(distance);
        } else {
            System.out.printf("%s не хочет плыть, считает, что далеко\n", getName());
        }
    }
}
