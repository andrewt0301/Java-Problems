
package ru.andrewt.concurrent.experiments;

import java.util.Enumeration;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * This is a wrapper class that allows enumerating an iterator from multiple threads.
 * <p>
 * It ensures that the {@code nextElement} method returns a valid element even if another
 * thread has been scheduled between {@code hasMoreElements} and {@code nextElement}.
 *
 * @param <T> Element type.
 */
public class ConcurrentEnumeration<T> implements Enumeration<T> {

  /** Iterator to be synchronized. */
  private final Enumeration<T> en;

  /** The next element cached for the current thread. */
  private final ThreadLocal<T> next;

  /**
   * Constructs a synchronized iterator.
   *
   * @param en Iterator to be synchronized.
   */
  public ConcurrentEnumeration(Enumeration<T> en) {
    this.en = Objects.requireNonNull(en);
    this.next = new ThreadLocal<>();
  }

  @Override
  public synchronized boolean hasMoreElements() {

    if (next.get() != null)
      return true;

    if (!en.hasMoreElements())
      return false;

    T element = en.nextElement();
    next.set(element);

    return true;
  }

  @Override
  public T nextElement() {

    T element = next.get();
    if (element == null) {
      if (!hasMoreElements()) {
        throw new NoSuchElementException();
      }
      element = next.get();
    }

    next.remove();
    return element;
  }

}
