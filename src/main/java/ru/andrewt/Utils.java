package ru.andrewt;

import java.util.Arrays;

public final class Utils {
  private Utils() {}

  public static void swap(final int[] a, final int i, final int j) {
    final int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static <T> T[] newArray(final int length) {
    return Arrays.copyOf(asArray(/*empty*/), length);
  }

  public static <T> T[] asArray(final T ... items) {
    return items;
  }

}
