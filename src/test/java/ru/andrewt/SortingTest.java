/*
 * Copyright 2018 AndrewT (https://github.com/andrewt0301)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package ru.andrewt;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Tests for the {@link Sorting} class.
 *
 * @author Andrei Tatarnikov
 */
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

  @Test
  public void testHeapSort() {
    final int[] data = Arrays.copyOf(UNSORTED, UNSORTED.length);
    HeapSort.heapsort(data);
    Assert.assertArrayEquals(SORTED, data);
  }

  @Test
  public void testCountingSort() {
    final int[] data = Arrays.copyOf(UNSORTED, UNSORTED.length);
    Sorting.countingSort(data, 10);
    Assert.assertArrayEquals(SORTED, data);
  }

  @Test
  public void testRadixSort() {
    final int[] data = Arrays.copyOf(UNSORTED, UNSORTED.length);
    Sorting.radixSort(data);
    Assert.assertArrayEquals(SORTED, data);
  }

  @Test
  public void testPartitionWithMask() {
    final int[] data = Arrays.copyOf(UNSORTED, UNSORTED.length);

    Sorting.partitionWithMask(data, 0b1);
    Assert.assertArrayEquals(new int[] {2, 6, 4, 2, 8, 9, 1, 3, 5, 3, 7}, data);

    Sorting.partitionWithMask(data, 0b10);
    Assert.assertArrayEquals(new int[] {4, 8, 9, 1, 5, 2, 6, 2, 3, 3, 7}, data);

    Sorting.partitionWithMask(data, 0b100);
    Assert.assertArrayEquals(new int[] {8, 9, 1, 2, 2, 3, 3, 4, 5, 6, 7}, data);

    Sorting.partitionWithMask(data, 0b1000);
    Assert.assertArrayEquals(SORTED, data);
  }

}
