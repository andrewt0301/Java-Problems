package ru.andrewt;

public final class Bits {
  private Bits() {}

  public static boolean isPowerOfTwo(final int value) {
    return value != 0 && (value & value - 1) == 0;
  }
}
