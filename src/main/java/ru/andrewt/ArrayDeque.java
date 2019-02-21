
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
  private T[] array;
  private int length;
  private int head;
  private int tail;

  public ArrayDeque(final int capacity) {
    this.array = ArrayUtils.newArray(capacity);
    this.length = 0;

    this.head = 0;
    this.tail = this.head;
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public boolean isFull() {
    return length == array.length;
  }

  public int getLength() {
    return length;
  }

  public void addFirst(final T value) {
    if (isFull()) {
      grow();
    }

    if (!isEmpty()) {
      head = prev(head);
    }

    array[head] = value;
    length++;
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

    if (!isEmpty()) {
      tail = next(tail);
    }

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
    T[] newArray = ArrayUtils.newArray(array.length);
    int cursor = head;

    for (int index = 0; index < length; ++index) {
      newArray[index] = array[cursor];
      cursor = next(cursor);
    }

    return newArray;
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append('[');

    int index = head;
    for (int i = 0; i < length; ++i) {
      if (i != 0) {
        builder.append(", ");
      }
      builder.append(array[index]);
      index = next(index);
    }

    builder.append(']');
    return builder.toString();
  }

  private void grow() {
    T[] newArray = ArrayUtils.newArray(array.length * 2);

    if (head < tail) {
      System.arraycopy(array, head, newArray, 0,tail - head);
    } else {
      final int headLength = array.length - head;
      System.arraycopy(array, head, newArray, 0, headLength);
      System.arraycopy(array, 0, newArray, headLength, tail + 1);
    }

    array = newArray;
    head = 0;
    tail = length - 1;
  }

  private int prev(final int index) {
    return (index == 0 ? array.length : index) - 1;
  }

  private int next(final int index) {
    final int nextIndex = index + 1;
    return nextIndex == array.length ? 0 : nextIndex;
  }

}
