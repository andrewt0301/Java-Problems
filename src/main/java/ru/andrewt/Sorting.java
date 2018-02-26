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

  public static void quickSort(final int[] data) {
    quickSort(data, 0, data.length - 1);
  }

  private static void quickSort(final int[] data, final int start, final int end) {
    if (start < end) {
      final int split = partition(data, start, end);
      quickSort(data, start, split - 1);
      quickSort(data, split + 1, end);
    }
  }

  private static int partition(final int[] data, final int start, final int end) {
    final int pivot = data[end];
    int split = start;

    for (int index = start; index < end; index++) {
      if (data[index] <= pivot) {
        swap(data, split, index);
        split++;
      }
    }

    swap(data, split, end);
    return split;
  }

  private static void swap(final int[] data, final int firstIndex, final int secondIndex) {
    final int temp = data[firstIndex];
    data[firstIndex] = data[secondIndex];
    data[secondIndex] = temp;
  }
}
