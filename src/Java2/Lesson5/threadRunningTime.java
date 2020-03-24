package Java2.Lesson5;

public class threadRunningTime extends Thread {

    private float[] multiple;
    int half;

    public threadRunningTime(String name, float[] multiple, int half) {
        super(name);
        this.multiple = multiple;
        this.half = half;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < multiple.length; i++) {
            multiple[i] = 1;
        }
        for (int i = 0; i < multiple.length; i++) {
            multiple[i] = (float) (multiple[i] * Math.sin(0.2f + (i+half) / 5) * Math.cos(0.2f + (i+half) / 5) * Math.cos(0.4f + (i+half) / 2));
        }
    }
}
