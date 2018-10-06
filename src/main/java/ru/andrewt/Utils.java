package ru.andrewt;

public final class Utils {
    private Utils() {}

    public static void swap(final int[] a, final int i, final int j) {
        final int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
