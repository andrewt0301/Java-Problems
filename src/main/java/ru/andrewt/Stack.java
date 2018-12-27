package ru.andrewt;

import java.util.NoSuchElementException;

/**
 * The {@link Stack} class is an implementation of the stack data structure based on a linked list.
 *
 * @param <T> Type of elements stored in the stack.
 *
 * @author Andrei Tatarnikov
 */
public class Stack<T> {

  ListNode<T> head;
  int length;

  public void Stack() {
    this.head = null;
    this.length = 0;
  }

  public boolean isEmpty() {
    return head == null;
  }

  public int getLength() {
    return length;
  }

  public void push(T value) {
    ListNode<T> node = new ListNode<>(value, head);
    head = node;
    ++length;
  }

  public T peek() {
    if (null == head) {
      throw new NoSuchElementException();
    }
    return head.value;
  }

  public T pop() {
    if (null == head) {
      throw new NoSuchElementException();
    }

    T value = head.value;
    head = head.next;
    return value;
  }

  public T[] toArray() {
    return ListUtils.toArray(head, length);
  }

  @Override
  public String toString() {
    return ListUtils.toString(head);
  }

}
