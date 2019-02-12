
package ru.andrewt;

/**
 * The {@link Deque} class implements the deque (double-ended queue) data structure.
 * <p>
 * The deque is implemented as a circular array. The array grows when free space finishes.
 * </p>
 * @param <T> Type of data items stored in the deque.
 *
 * @author Andrei Tatarnikov
 */
public class ArrayDeque<T> {
  protected final T[] array;
  protected int length;
  protected int head;
  protected int tail;

  public ArrayDeque(final int capacity) {
    this.array = ArrayUtils.newArray(capacity);
    this.length = 0;

    this.head = capacity / 2;
    this.tail = this.head;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  protected boolean isFull() {
    return length == array.length;
  }

  public int getLength() {
    return length;
  }

  public void addFirst(final T value) {
    if (isFull()) {
      grow();
    }

    head = prev(head);
    array[head] = value;
    ++length;
  }

  public T peekFirst() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException();
    }
    return array[head];
  }

  public T removeFirst() {
    final T value = peekFirst();

    head = next(head);
    --length;

    return value;
  }

  public void addLast(final T value) {
    if (isFull()) {
      grow();
    }

    tail = next(tail);
    array[tail] = value;
    ++length;
  }

  public T peekLast() {
    if (isEmpty()) {
       throw new IndexOutOfBoundsException();
    }
    return array[tail];
  }

  public T removeLast() {
    final T value = peekFirst();

    tail = prev(tail);
    --length;

    return value;
  }

  public T[] toArray() {
    return null;
  }

  @Override
  public String toString() {
    return null;
  }

  protected void grow() {
      // TODO
  }

  protected int prev(int index) {
    return (index == 0 ? array.length : index) - 1;
  }

  protected int next(int index) {
    return ++index == array.length ? 0 : index;
  }

}
