
package ru.andrewt.concurrent;

import java.util.Random;

public class Backoff {
  private final Random random;
  private final int maxDelay;
  private int limit;

  public Backoff(int min, int max) {
    random = new Random();
    maxDelay = max;
    limit = min;
  }

  public void backoff() {
    int delay = random.nextInt(limit);
    limit = Math.min(maxDelay, 2 * limit);

    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
