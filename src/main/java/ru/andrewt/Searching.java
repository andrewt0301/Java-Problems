
package ru.andrewt;

/**
 * The {@link Searching} class provides methods that implement various searching algorithms.
 *
 * @author Andrei Tatarnikov
 */
public final class Searching {
  private Searching() {}

  /**
   * Performs linear search for the specified key in the array of integers
   * and returns the position of the found element.
   * <p>
   * Time complexity: O(N), where N is the length of the array.
   * <p/>
   * @param data Array of integers.
   * @param key Key to be searched.
   * @return Position of the first occurrence of the key in the array
   *         or {@code -1} if the key is not found.
   */
  public static int linearSearch(final int[] data, final int key) {
    for (int index = 0; index < data.length; ++index) {
      if (key == data[index]) {
        return index;
      }
    }
    return -1;
  }

  /**
   * Finds the minimal element in the specified array of integers.
   * <p>
   * Time complexity: O(N), where N is the length of the array.
   * <p/>
   * @param data Array of integers.
   * @return Value of the minimal element.
   */
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

  /**
   * Finds the maximal element in the specified array of integers.
   * <p>
   * Time complexity: O(N), where N is the length of the array.
   * <p/>
   * @param data Array of integers.
   * @return Value of the maximal element.
   */
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

  /**
   * Finds both the minimal and maximal element in the specified array of integers.
   * <p>
   * Time complexity: O(N), where N is the length of the array.
   * <p/>
   * @param data Array of integers.
   * @return Array of values of the minimal element and the maximal element ({@code [min, max]}).
   */
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

  /**
   * Performs binary search for the specified key in the sorted array of integers and returns
   * the position of the found element. If the array is not sorted, the result is undefined.
   * If the array contains multiple elements with the specified value, there is no guarantee
   * which one will be found.
   * <p>
   * Time complexity: O(lg(N)), where N is the length of the array.
   * <p/>
   * @param data Array of integers.
   * @param key Key to be searched.
   * @return Position of the key in the array or {@code -1} if the key is not found.
   */
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

  /**
   * Searches an array of integers for a subarray that gives maximum possible
   * sum of its elements.
   * <p>
   * Time complexity: O(N lg(N)), where N is the length of the array.
   * <p/>
   * @param data Array of integers.
   * @return Tuple describing the subarray being found: [start, end, sum of elements].
   */
  public static int[] findMaxSubarray(final int[] data) {
    return findMaxSubarray(data, 0, data.length - 1);
  }

  /**
   * Searches an array of integers within the specified range for a subarray that gives maximum
   * possible sum of its elements.
   * <p>
   * Time complexity: O(N lg(N)), where N is the length of the search range.
   * <p/>
   * @param data Array of integers.
   * @param low Low position of the search range.
   * @param high High position of the search range.
   * @return Tuple describing the subarray being found:
   *         [low position, high position, sum of elements].
   */
  public static int[] findMaxSubarray(final int[] data, final int low, final int high) {

    if (low == high) {
      return new int[] { low, high, data[low] };
    }

    final int mid = (low + high) / 2;

    final int[] left = findMaxSubarray(data, low, mid);
    final int[] right = findMaxSubarray(data, mid + 1, high);
    final int[] crossing = findMaxSubarrayCrossing(data, low, mid, high);

    if (left[2] >= right[2] && left[2] >= crossing[2]) {
      return left;
    }

    if (right[2] >= left[2] && right[2] >= crossing[2]) {
      return right;
    }

    return crossing;
  }

  /**
   * Searches an array of integers within the specified range for a subarray that gives maximum
   * possible sum of its elements. The subarray must be located in the middle of the search range
   * (that is it must include the middle element and some lower or higher elements).
   * <p>
   * Time complexity: O(N), where N is the length of the search range.
   * <p/>
   * @param data Array of integers.
   * @param low Low position of the search range.
   * @param mid Middle position of the search range.
   * @param high High position of the search range.
   * @return Tuple describing the subarray being found:
   *         [low position, high position, sum of elements].
   */
  public static int[] findMaxSubarrayCrossing(
      final int[] data,
      final int low,
      final int mid,
      final int high) {

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
      if (sum > rightSum) {
        rightSum = sum;
        maxRight = i;
      }
    }

    return new int[] { maxLeft, maxRight, leftSum + rightSum };
  }

}
