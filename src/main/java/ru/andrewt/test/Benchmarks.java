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
