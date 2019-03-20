
package ru.andrewt;

/**
 * The {@link Bits} class provides utility methods for various bit manipulations.
 *
 * @author Andrei Tatarnikov
 */
public final class Bits {
  private Bits() {}

  /**
   * Checks whether the specified integer value is a power of two.
   *
   * @param value Integer value.
   * @return {@code true} if the value is a power of two or {@code false} otherwise.
   */
  public static boolean isPowerOfTwo(final int value) {
    return value != 0 && (value & value - 1) == 0;
  }


  /**
   * Counts bits set to 1 in an integer value.
   * Efficient for values that have a relatively small number of bits set to 1.
   *
   * @param value Integer value.
   * @return Number of bits set to 1 in the integer value.
   */
  public static int getBitCount(final int value) {

    int count = 0;
    for (int v = value; v != 0; v &= v - 1) {
      ++count;
    }
    return count;
  }

}
