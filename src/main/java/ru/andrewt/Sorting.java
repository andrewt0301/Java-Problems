package ru.andrewt;

public final class Sorting {
  private Sorting() {}

  public static void insertionSort(final int[] data) {
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

  public static void bubbleSort(final int[] data) {
    for (int i = 0; i < data.length - 1; i++) {
      for (int j = data.length - 1; j > i; j--) {
        final int k = j - 1;
        if (data[j] < data[k]) {
          swap(data, j, k);
        }
      }
    }
  }

  private static void swap(final int[] data, final int firstIndex, final int secondIndex) {
    final int temp = data[firstIndex];
    data[firstIndex] = data[secondIndex];
    data[secondIndex] = temp;
  }
}
