
package ru.andrewt;

import java.util.Arrays;

/**
 * The {@link Sorting} class provides methods that implement various kinds of sorting algorithms.
 *
 * @author Andrei Tatarnikov
 */
public final class Sorting {
  private Sorting() {}

  /**
   * Sorts an array of integers into ascending numerical order using the insertion sort algorithm.
   * <p>
   * Time complexity: {@code Θ(N^2)}, where N is the length of the array.
   * <p/>
   * @param data Array to be sorted.
   */
  public static void insertionSort(final int[] data) {

    for (int i = 1; i < data.length; ++i) {
      final int key = data[i];

      int j = i - 1;
      while (j >= 0 && data[j] > key) {
        data[j + 1] = data[j];
        --j;
      }

      data[j + 1] = key;
    }
  }

  /**
   * Sorts an array of integers into ascending numerical order using the bubble sort algorithm.
   * <p>
   * Time complexity: {@code O(N^2)}, where N is the length of the array.
   * <p/>
   * @param data Array to be sorted.
   */
  public static void bubbleSort(final int[] data) {

    for (int i = 0; i < data.length - 1; ++i) {
      boolean isNoSwaps = true;

      for (int j = data.length - 1; j > i; --j) {
        final int k = j - 1;
        if (data[j] < data[k]) {
          ArrayUtils.swap(data, j, k);
          isNoSwaps = false;
        }
      }

      if (isNoSwaps) {
        break;
      }
    }
  }

  /**
   * Sorts an array of integers into ascending numerical order using the selection sort algorithm.
   * <p>
   * Time complexity: {@code Θ(N^2)}, where N is the length of the array.
   * <p/>
   * @param data Array to be sorted.
   */
  public static void selectionSort(final int[] data) {

    for (int i = 0; i < data.length; ++i) {

      int min = i;
      for (int j = i + 1; j < data.length; ++j) {
        if (data[j] < data[min]) {
          min = j;
        }
      }

      if (i != min) {
        ArrayUtils.swap(data, i, min);
      }
    }
  }

  public static void quickSort(final int[] data) {
    quickSort(data, 0, data.length - 1);
  }

  public static void quickSort(final int[] data, final int start, final int end) {

    if (start < end) {
      final int split = partition(data, start, end);
      quickSort(data, start, split - 1);
      quickSort(data, split + 1, end);
    }
  }

  private static int partition(final int[] data, final int start, final int end) {

    final int pivot = data[end];
    int split = start;

    for (int i = start; i < end; ++i) {
      if (data[i] <= pivot) {
        ArrayUtils.swap(data, split, i);
        split++;
      }
    }

    ArrayUtils.swap(data, split, end);
    return split;
  }

  /**
   * Sorts an array of integers into ascending numerical order using the merge sort algorithm.
   * <p>
   * Time complexity: {@code Θ(N lg N)}, where N is the length of the array.
   * <p/>
   * @param data Array to be sorted.
   */
  public static void mergeSort(final int[] data) {
    mergeSort(data, 0, data.length - 1);
  }

  /**
   * Sorts the specified range in an array of integers into ascending
   * numerical order using the merge sort algorithm.
   * <p>
   * Time complexity: {@code Θ(N lg N)}, where N is the length of the sorted range.
   * <p/>
   * @param data Array to be sorted.
   * @param start Range start index (included).
   * @param end Range end index (included).
   */
  public static void mergeSort(final int[] data, final int start, final int end) {

    if (start < end) {
      final int split = (start + end) / 2;

      mergeSort(data, start, split);
      mergeSort(data, split + 1, end);

      merge(data, start, split, end);
    }
  }


  /**
   * Merges two adjacent sorted ranges in an integer array into a single sorted range.
   *
   * @param data Array to be merged.
   * @param start Start position of the first range (included).
   * @param split End position of the first range, followed by start position of the second range
   *             (included).
   * @param end End position of the second range (included).
   */
  private static void merge(int[] data, int start, int split, int end) {

    // Creates a copy of the first (left) range.
    final int leftLen = split - start + 1;
    final int[] leftData = new int[leftLen + 1];
    System.arraycopy(data, start, leftData, 0, leftLen);
    leftData[leftLen] = Integer.MAX_VALUE;

    // Creates a copy of the second (right) range.
    final int rightLen = end - split;
    final int[] rightData = new int[rightLen + 1];
    System.arraycopy(data, split + 1, rightData, 0, rightLen);
    rightData[rightLen] = Integer.MAX_VALUE;

    // Merges the two ranges and saves the result to the data array.
    for (int index = start, leftIndex = 0, rightIndex = 0; index <= end; ++index) {
      final int left = leftData[leftIndex];
      final int right = rightData[rightIndex];

      if (left <= right) {
        data[index] = left;
        leftIndex++;
      } else {
        data[index] = right;
        rightIndex++;
      }
    }
  }

  public static void countingSort(final int[] data, final int rangeSize) {
    final int[] counts = new int[rangeSize];
    Arrays.fill(counts, 0);

    for (final int value : data) {
      counts[value]++;
    }

    for (int i = 1; i < counts.length; ++i) {
      counts[i] += counts[i - 1];
    }

    final int[] dataCopy = Arrays.copyOf(data, data.length);
    for (int i = data.length - 1; i >=0; --i) {
      final int value = dataCopy[i];
      final int count = counts[value];

      data[count - 1] = value;
      counts[value]--;
    }
  }

  public static void radixSort(final int[] data) {
    for (int mask = 1; mask != 0; mask <<= 1) {
      partitionWithMask(data, mask);
    }
  }

  /**
   * Partitions an array of integers checking whether they satisfy the bit mask.
   *
   * <p>Values unsatisfying the mask are placed first and the ones satisfying the mask are
   * placed next. The partition is stable (does not break relative order of values belonging
   * to the same partitions).</p>
   *
   * @param data Array of integer values.
   * @param mask Bit mask used for partitioning.
   */
  public static void partitionWithMask(final int[] data, final int mask) {

    // End position of the first partition.
    int partitionIndex = 0;

    for (int index = 0; index < data.length; ++index) {
      final int value = data[index];
      if ((value & mask) == 0) {
        if (index > partitionIndex) {
          // Moves the value to the first partition.
          final int length = index - partitionIndex;
          ArrayUtils.shiftHigh(data, partitionIndex, length);
          data[partitionIndex] = value;
        }
        partitionIndex++;
      }
    }
  }

}
