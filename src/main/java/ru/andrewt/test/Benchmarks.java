
package ru.andrewt.test;

/**
 * The {@link Benchmarks} class provides utility methods for measuring performance.
 *
 * @author Andrei Tatarnikov
 */
public final class Benchmarks {
  private Benchmarks() {}

  /**
   * Measures execution time of the specified function in milliseconds.
   *
   * @param runnable Some function.
   * @return Execution time in milliseconds.
   */
  public static long calcExecTimeMillis(final Runnable runnable) {
    final long before = System.currentTimeMillis();
    runnable.run();
    final long after = System.currentTimeMillis();
    return after - before;
  }

  /**
   * Measures average execution time of the specified function in milliseconds.
   *
   * @param runnable Some function.
   * @param count Number of times the function is executed to measure its average execution time.
   * @return Average execution time in milliseconds.
   */
  public static long calcAverageExecTimeMillis(final Runnable runnable, final int count) {
    final long before = System.currentTimeMillis();
    for (int i = 0; i < count; ++i) {
      runnable.run();
    }
    final long after = System.currentTimeMillis();

    final long average = (after - before) / count;
    return average;
  }

  /**
   * Measures execution time of the specified function in nanoseconds.
   *
   * @param runnable Some function.
   * @return Execution time in nanoseconds.
   */
  public static long calcExecTimeNanos(final Runnable runnable) {
    final long before = System.nanoTime();
    runnable.run();
    final long after = System.nanoTime();
    return after - before;
  }

  /**
   * Measures average execution time of the specified function in nanoseconds.
   *
   * @param runnable Some function.
   * @param count Number of times the function is executed to measure its average execution time.
   * @return Average execution time in nanoseconds.
   */
  public static long calcAverageExecTimeNanos(final Runnable runnable, final int count) {
    final long before = System.nanoTime();
    for (int i = 0; i < count; ++i) {
      runnable.run();
    }
    final long after = System.nanoTime();

    final long average = (after - before) / count;
    return average;
  }

}
