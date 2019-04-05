
package ru.andrewt.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Lock based on the test-and-set (TAS) instruction.
 *
 * {@see <a https://en.wikipedia.org/wiki/Test-and-set"/>}
 */
public class TASLock implements Lock {
  private final AtomicBoolean state = new AtomicBoolean(false);

  @Override
  public void lock() {
    while (state.getAndSet(true)) {}
  }

  @Override
  public void unlock() {
    state.set(false);
  }

}
