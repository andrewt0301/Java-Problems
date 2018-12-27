
package ru.andrewt.test;

/**
 * The {@link Benchmarks} class provides utility methods for measuring performance.
 *
 * @author Andrei Tatarnikov
 */
public final class Benchmarks {
  private Benchmarks() {}

  public static long calcExecTimeMillis(final Runnable runnable) {
      final long before = System.currentTimeMillis();
      runnable.run();
      final long after = System.currentTimeMillis();
      return after - before;
  }

  public static long calcAverageExecTimeMillis(final Runnable runnable, final int count) {
    final long before = System.currentTimeMillis();
    for (int i = 0; i < count; ++i) {
      runnable.run();
    }
    final long after = System.currentTimeMillis();

    final long average = (after - before) / count;
    return average;
  }

  public static long calcExecTimeNanos(final Runnable runnable) {
    final long before = System.nanoTime();
    runnable.run();
    final long after = System.nanoTime();
    return after - before;
  }

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
