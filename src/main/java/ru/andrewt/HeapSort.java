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

import static ru.andrewt.ArrayUtils.swap;

public final class HeapSort {
  private HeapSort() {}

  private static int parent(int i) {
    return (i - 1) / 2;
  }

  private static int left(int i) {
    return 2 * i + 1;
  }

  private static int right(int i) {
    return 2 * i + 2;
  }

  public static void max_heapify(final int a[], final int size, final int i) {
    int largest = i;

    final int l = left(i);
    if (l < size && a[l] > a[largest]) {
      largest = l;
    }

    final int r = right(i);
    if (r < size && a[r] > a[largest]) {
      largest = r;
    }

    if (largest != i) {
      swap(a, i, largest);
      max_heapify(a, size, largest);
    }
  }

  public static void build_max_heap(final int a[]) {
    final int size = a.length;
    for (int i = size / 2; i >= 0; i--) {
      max_heapify(a, size, i);
    }
  }

  public static void heapsort(final int a[]) {
    build_max_heap(a);

    int size = a.length;
    for (int i = a.length - 1; i >= 1; i--) {
      swap(a, i, 0);
      size--;
      max_heapify(a, size, 0);
    }
  }
}
