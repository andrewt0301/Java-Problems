
package ru.andrewt.concurrent;

/**
 * Base interface for all locks.
 * Simplified version of {@link java.util.concurrent.locks.Lock} with only basic methods.
 */
public interface Lock {

  /** Acquires the lock. */
  void lock();

  /** Releases the lock. */
  void unlock();

}

