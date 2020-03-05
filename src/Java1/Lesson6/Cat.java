package Java1.Lesson6;

public class Cat extends Animal {
//    public Cat(String name) {
//        super(name);
//    }


    @Override
    public void run(int distance) {
        if (distance < 200) {
            super.run(distance);
        } else {
            System.out.format("%s устал(а) и отдыхает\n", getName());
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > 0) {
            System.out.format("%s не умеет плавать\n", getName());
        }
    }
}