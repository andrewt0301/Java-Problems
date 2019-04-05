
package ru.andrewt.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Lock based on the test and test-and-set (TTAS) instruction.
 *
 * {@see <a https://en.wikipedia.org/wiki/Test_and_test-and-set"/>}
 */
public class TTASLock implements Lock {
  private final AtomicBoolean state = new AtomicBoolean(false);

  @Override
  public void lock() {
    while (true) {
      while (state.get())
      if (!state.getAndSet(true)) {
        return;
      }
    }
  }

  @Override
  public void unlock() {
    state.set(false);
  }

}
