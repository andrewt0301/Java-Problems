
package ru.andrewt.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;

public class BackoffLock implements Lock {
  private static final int MIN_DELAY = 10;
  private static final int MAX_DELAY = 100;
  private final AtomicBoolean state = new AtomicBoolean(false);

  @Override
  public void lock() {
    final Backoff backoff = new Backoff(MIN_DELAY, MAX_DELAY);
    while (true) {
      while (state.get()) {}
      if (!state.getAndSet(true)) {
        return;
      } else {
        backoff.backoff();
      }
    }
  }

  @Override
  public void unlock() {
    state.set(false);
  }

}
