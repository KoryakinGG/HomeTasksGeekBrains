package Java2.Lesson5;

public class Threads extends Thread {

    public static void main(String[] args) {
        singleStream();
        multiStream();
    }

    private static synchronized void multiStream() {
        long start = System.currentTimeMillis();
        int size = 10000000;
        int half = size / 2;

        float[] array = new float[size];
        float[] array1 = new float[half];
        float[] array2 = new float[half];

        System.arraycopy(array, 0, array1, 0, half);
        System.arraycopy(array, 0, array2, 0, half);

        new threadRunningTime("1 stream", array1);
        new threadRunningTime("2 stream", array2);

        System.arraycopy(array1, 0, array, 0, half);
        System.arraycopy(array2, 0, array, half, half);
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void singleStream() {
        int size = 10_000_000;
        float[] array = new float[size];
        long start = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - start);
    }
}
