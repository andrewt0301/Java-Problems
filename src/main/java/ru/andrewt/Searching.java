
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

  public static int[] findMaxSubarray(final int[] data) {
    return findMaxSubarray(data, 0, data.length -1);
  }

  public static int[] findMaxSubarray(final int[] data, final int low, final int high) {

    if (low == high) {
      return new int[] { low, high, data[low] };
    }

    final int mid = (low + high) / 2;

    final int[] left = findMaxSubarray(data, low, mid);
    final int[] right = findMaxSubarray(data, mid + 1, high);
    final int[] crossing = findCrossingSubarray(data, low, mid, high);

    if (left[2] >= right[2] && left[2] >= crossing[2]) {
      return left;
    }

    if (right[2] >= left[2] && right[2] >= crossing[2]) {
      return left;
    }

    return crossing;
  }

  public static int[] findCrossingSubarray(final int[] data, final int low, final int mid, final int high) {

    int leftSum = Integer.MIN_VALUE;
    int maxLeft = -1;
    int sum = 0;

    for (int i = mid; i >= low; --i) {
      sum += data[i];
      if (sum > leftSum) {
        leftSum = sum;
        maxLeft = i;
      }
    }

    int rightSum = Integer.MIN_VALUE;
    int maxRight = -1;
    sum = 0;

    for (int i = mid + 1; i <= high; ++i) {
      sum += data[i];
      if (sum > maxRight) {
        rightSum = sum;
        maxRight = i;
      }
    }

    return new int[] { maxLeft, maxRight, leftSum + rightSum };
  }

}
