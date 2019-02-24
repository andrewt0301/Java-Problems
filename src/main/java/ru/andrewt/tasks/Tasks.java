
package ru.andrewt.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@link Tasks} class is a collection of methods that solve
 * tasks from various code interviews.
 */
public final class Tasks {
  private Tasks() {}

  /**
   * Finds the length of longest subarray having sum {@code k}.
   * <p>
   * Time complexity: O(N), where N is the length of the array.
   * <p/>
   * @param data Array of integers.
   * @param k Sum of elements of the subarray being searched.
   * @return Length of longest subarray having sum {@code k}.
   */
  public static int lengthOfLongestSubarray(final int[] data, final int k) {

    // HashMap to store (sum, index) pairs.
    final Map<Integer, Integer> sumsAndPos = new HashMap<>();

    int sum = 0;
    int maxLen = 0;

    for (int i = 0; i < data.length; i++) {
      sum += data[i];

      // Add an entry for 'sum' if it is not added yet.
      if (!sumsAndPos.containsKey(sum)) {
        sumsAndPos.put(sum, i);
      }

      // When subarray starts from index '0'.
      if (sum == k) {
        maxLen = i + 1;
      } else {
        // Find position of the prefix that gives 'sum - k' if it is present in the map.
        final Integer prefixPos = sumsAndPos.get(sum - k);
        if (prefixPos != null) {
          final int lenWithoutPrefix = i - prefixPos;
          if (maxLen < lenWithoutPrefix) {
            maxLen = lenWithoutPrefix;
          }
        }
      }
    }

    return maxLen;
  }

}
