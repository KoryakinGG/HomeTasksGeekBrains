package Java2.Lesson5;

public class threadRunningTime extends Thread {

    private float[] multiple;

    public threadRunningTime(String name, float[] multiple) {
        super(name);
        this.multiple = multiple;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < multiple.length; i++) {
            multiple[i] = 1;
        }
        for (int i = 0; i < multiple.length; i++) {
            multiple[i] = (float) (multiple[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
