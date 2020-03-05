package Java1.Lesson7;

import java.util.Scanner;

public class Plate {
    Scanner scanner = new Scanner((System.in));
    private int food;

    protected Plate(int food) {
        this.food = food;
    }

    protected void info() {
        System.out.println("Food in plate: " + food);
    }

    protected boolean decreaseFood(int appetite) {
        if (appetite > food) {
            return false;
        }

        food -= appetite;
        return true;
    }

    protected void putTheFood() {
        int put = scanner.nextInt();
        this.food += put;
    }

}
