
package ru.andrewt;

import java.util.NoSuchElementException;

/**
 * The {@link ListQueue} class is an implementation of the queue data structure based on a linked list.
 *
 * @param <T> Type of elements stored in the queue.
 *
 * @author Andrei Tatarnikov
 */
public class ListQueue<T> {

  ListNode<T> head;
  ListNode<T> tail;
  int length;

  public ListQueue(final T... values) {
    this();

    for (int index = 0; index < values.length; index++) {
      enqueue(values[index]);
    }
  }

  public ListQueue() {
    this.head = null;
    this.head = tail;
    this.length = 0;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int getLength() {
    return length;
  }

  public void enqueue(T value) {
    ListNode<T> node = new ListNode<>(value, null);

    if (null == tail) {
      head = node;
    }
    else {
      tail.next = node;
    }

    tail = node;
    ++length;
  }

  public T peekFirst() {
    if (null == head) {
      throw new NoSuchElementException();
    }
    return head.value;
  }

  public T dequeue() {
    if (null == head) {
      throw new NoSuchElementException();
    }

    T value = head.value;
    head = head.next;
    return value;
  }

  public T peekLast() {
    if (null == tail) {
      throw new NoSuchElementException();
    }
    return tail.value;
  }

  public T[] toArray() {
    return ListUtils.toArray(head, length);
  }

  @Override
  public String toString() {
    return ListUtils.toString(head);
  }

}
