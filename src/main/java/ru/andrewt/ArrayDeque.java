
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

    if (head == tail) {
      tail = next(tail);
    }

    array[head] = value;
    head = prev(head);

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

    if (head == tail) {
      head = prev(head);
    }

    array[tail] = value;
    tail = next(tail);

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
    int index = head;

    for (int position = 0; position < newArray.length; ++position) {
      newArray[position] = array[index];
      index = next(index);
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
      index = next(index);
      builder.append(array[index]);
    }

    builder.append(']');
    return builder.toString();
  }

  private void grow() {

    // TODO
    T[] newArray = ArrayUtils.newArray(array.length * 2);

    int h = next(head);
    int t = prev(tail);

    System.arraycopy(array, h, newArray, 0,array.length - h);
    System.arraycopy(array, 0, newArray, array.length - head,tail);

    array = newArray;
    head = 0;
    tail = length;
  }

  private int prev(int index) {
    return (index == 0 ? array.length : index) - 1;
  }

  private int next(int index) {
    return ++index == array.length ? 0 : index;
  }

}
