package ru.andrewt;

public final class Sorting {
  private Sorting() {}

  public static void insertionSort(final int[] data) {
    if (data.length < 2) {
      return;
    }

    for (int i = 1; i < data.length; i++) {
      final int key = data[i];

      int j = i - 1;
      while (j >= 0 && data[j] > key) {
        data[j + 1] = data[j];
        j--;
      }

      data[j + 1] = key;
    }
  }
}
