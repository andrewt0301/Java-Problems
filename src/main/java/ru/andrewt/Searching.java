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

/**
 * The {@link Searching} class provides methods that implement various searching algorithms.
 *
 * @author Andrei Tatarnikov
 */
public final class Searching {
  private Searching() {}

  public static int linearSearch(final int[] data, final int key) {
    for (int index = 0; index < data.length; ++index) {
      if (key == data[index]) {
        return index;
      }
    }
    return -1;
  }

  public static int min(final int[] data) {
    int min = data[0];
    for (int index = 1; index < data.length; ++index) {
      int value = data[index];
      if (value < min) {
        min = value;
      }
    }
    return min;
  }

  public static int max(final int[] data) {
    int max = data[0];
    for (int index = 1; index < data.length; ++index) {
      final int value = data[index];
      if (value > max) {
        max = value;
      }
    }
    return max;
  }

  public static int[] minAndMax(final int[] data) {
    int min = data[0];
    int max = min;

    for (int index = 1; index < data.length; ++index) {
      final int value = data[index];
      if (value < min) {
        min = value;
      } else if (value > max) {
        max = value;
      }
    }

    return new int[] { min, max };
  }

  public static int binarySearch(final int[] data, final int key) {
    int low = 0;
    int high = data.length - 1;

    while (low <= high) {
      final int mid = (low + high) / 2;
      final int midVal = data[mid];

      if (key > midVal) {
        low = mid + 1;
      } else if (key < midVal) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;
  }

}
