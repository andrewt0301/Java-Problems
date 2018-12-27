
package ru.andrewt;

import java.util.Arrays;

/**
 * The {@link ArrayUtils} class provides utility methods to manipulate with arrays.
 */
public final class ArrayUtils {
  private ArrayUtils() {}

  /**
   * Swaps two array elements.
   *
   * @param array Array.
   * @param first First element.
   * @param second Second element.
   */
  public static void swap(final int[] array, final int first, final int second) {
    final int temp = array[first];
    array[first] = array[second];
    array[second] = temp;
  }

  /**
   * Moves an array element from one position to another.
   *
   * @param array Array.
   * @param from From position.
   * @param to To position.
   */
  public static void move(final int[] array, final int from, final int to) {
    if (from == to) {
      return;
    }

    final int value = array[from];
    if (from < to) {
      final int length = to - from;
      shiftLow(array, from + 1, length);
    } else {
      final int length = from - to;
      shiftHigh(array, to, length);
    }
    array[to] = value;
  }

  /**
   * Shifts the specified subarray by one element towards higher indices.
   *
   * @param array Array.
   * @param start Index of the starting element of the subarray to be shifted.
   * @param length Length of the subarray to be shifted.
   */
  public static void shiftHigh(final int[] array, final int start, final int length) {
    System.arraycopy(array, start, array, start + 1, length);
  }

  /**
   * Shifts the specified subarray by one element towards lower indices.
   *
   * @param array Array.
   * @param start Index of the starting element of the subarray to be shifted.
   * @param length Length of the subarray to be shifted.
   */
  public static void shiftLow(final int[] array, final int start, final int length) {
    System.arraycopy(array, start, array, start - 1, length);
  }

  /**
   * Creates a new array of the specified type and length. Optionally copies the
   * specified values into the created array.
   *
   * <p>Implemented to be able to create typed arrays. The {@code old} parameter is declared
   * mainly to be able to specify element type (hack to overcome some language limitations).
   * Normally, it is not used.</p>
   *
   * @param length Array length.
   * @param old (optional) Values to be placed into the array.
   * @param <T> Array element type.
   * @return Array of the specified type and length.
   */
  public static <T> T[] newArray(final int length, final T... old) {
    return Arrays.copyOf(old, length);
  }

}
