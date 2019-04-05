
package ru.andrewt.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadId {

  private static final AtomicInteger nextId =
      new AtomicInteger(0);

  private static final ThreadLocal<Integer> threadId =
      ThreadLocal.withInitial(nextId::getAndIncrement);

  public static int get() {
    return threadId.get();
  }

  public static void set(int index) {
    threadId.set(index);
  }

}
