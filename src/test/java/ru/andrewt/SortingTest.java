package ru.andrewt;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SortingTest {
  static final int[] SORTED = new int[] {1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9};
  static final int[] UNSORTED = new int[] {9, 1, 3, 5, 2, 6, 3, 7, 4, 2, 8};

  @Test
  public void testInsertionSort() {
    final int[] data = Arrays.copyOf(UNSORTED, UNSORTED.length);
    Sorting.insertionSort(data);
    Assert.assertArrayEquals(SORTED, data);
  }

  @Test
  public void testBubbleSort() {
    final int[] data = Arrays.copyOf(UNSORTED, UNSORTED.length);
    Sorting.bubbleSort(data);
    Assert.assertArrayEquals(SORTED, data);
  }

  @Test
  public void testMergeSort() {
    final int[] data = Arrays.copyOf(UNSORTED, UNSORTED.length);
    Sorting.mergeSort(data);
    Assert.assertArrayEquals(SORTED, data);
  }

  @Test
  public void testQuickSort() {
    final int[] data = Arrays.copyOf(UNSORTED, UNSORTED.length);
    Sorting.quickSort(data);
    Assert.assertArrayEquals(SORTED, data);
  }
}
