package ru.andrewt;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingTest {

  @Test
  public void testInsertionSort() throws Exception {
    final int[] data = new int[] {9, 1, 5, 2, 6, 3, 7, 4, 8};
    Sorting.insertionSort(data);
    Assert.assertEquals(data, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
  }

  @Test
  public void testBubbleSort() throws Exception {
    final int[] data = new int[] {9, 1, 5, 2, 6, 3, 7, 4, 8};
    Sorting.bubbleSort(data);
    Assert.assertEquals(data, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
  }

}
