package ru.stepanov.se.threads;

import static java.lang.System.arraycopy;

public class App {
    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private final float[] array = new float[SIZE];
    private static final float[] arrayFirst = new float[HALF];
    private static final float[] arraySecond = new float[HALF];

    public static void main(String[] args) {
        App app = new App()
                .createArray()
                .elapsedSyncArray()
                .divisionArray();

        new Thread(() -> app.elapsedAsyncArray(arrayFirst)).start();
        new Thread(() -> app.elapsedAsyncArray(arraySecond)).start();

        app.concatenationArray();
    }

    private App divisionArray() {
        arraycopy(array, 0, arrayFirst, 0, HALF);
        arraycopy(array, HALF, arraySecond, 0, HALF);
        return this;
    }

    private void concatenationArray() {
        arraycopy(arrayFirst, 0, array, 0, HALF);
        arraycopy(arraySecond, 0, array, HALF, HALF);
    }

    private App elapsedSyncArray() {
        float[] array = new float[SIZE];
        long elapsedSync = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.currentTimeMillis();
        }
        System.out.println("Elapsed sync time: " + (System.currentTimeMillis() - elapsedSync) + " mls");
        return this;
    }

    private synchronized void elapsedAsyncArray(float[] divArray) {
        long elapsedAsync = System.currentTimeMillis();
        for (int i = 0; i < divArray.length; i++) {
            divArray[i] = (float) (divArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            System.currentTimeMillis();
        }

        System.out.println("Elapsed async time: " + (System.currentTimeMillis() - elapsedAsync) + " mls");

    }

    private App createArray() {
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        return this;
    }
}

