
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

}
