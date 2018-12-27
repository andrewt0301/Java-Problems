
package ru.andrewt;

/**
 * The {@link SinglyLinkedList} class implements the singly linked list data structure.
 *
 * @param <T> Type of elements stored in the list.
 *
 * @author Andrei Tatarnikov
 */
public final class SinglyLinkedList<T> {

  ListNode<T> head;
  ListNode<T> tail;
  int length;

  public SinglyLinkedList() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public SinglyLinkedList(final T... values) {
    this();
    for (int index = 0; index < values.length; index++) {
      add(values[index]);
    }
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public int getLength() {
    return length;
  }

  public void add(final T value) {
    final ListNode<T> node = new ListNode<>(value, null);
    if (tail == null) {
      head = node;
    } else {
      tail.next = node;
    }
    tail = node;
    length++;
  }

  public T get(final int index) {
    final ListNode<T> node = getNode(index);
    return node.value;
  }

  public void set(final int index, final T value) {
    final ListNode<T> node = getNode(index);
    node.value = value;
  }

  private ListNode<T> getNode(final int index) {
    checkBounds(index);

    ListNode<T> node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }

    return node;
  }

  public void insertAt(final int index, final T value) {
    if (index == length) {
      add(value);
      return;
    }

    checkBounds(index);

    ListNode<T> prev = null;
    ListNode<T> curr = head;

    for (int i = 0; i < index; i++) {
      prev = curr;
      curr = curr.next;
    }

    final ListNode<T> node = new ListNode<>(value, curr);

    if (prev == null) {
      head = node;
    } else {
      prev.next = node;
    }

    length++;
  }

  public void removeAt(final int index) {
    checkBounds(index);

    ListNode<T> prev = null;
    ListNode<T> curr = head;

    for (int i = 0; i < index; i++) {
      prev = curr;
      curr = curr.next;
    }

    if (prev == null) {
      head = head.next;
    } else {
      prev.next = prev.next.next;
    }

    if (curr == tail) {
      tail = prev;
    }

    length--;
  }

  public void reverse() {
    ListNode<T> newHead = null;
    ListNode<T> curr = head;

    while (curr != null) {
      final ListNode<T> node = curr;
      curr = curr.next;

      node.next = newHead;
      newHead = node;
    }

    head = newHead;
  }

  public T[] toArray() {
    return ListUtils.toArray(head, length);
  }

  @Override
  public String toString() {
    return ListUtils.toString(head);
  }

  private void checkBounds(final int index) {
    if (!(0 <= index && index < length)) {
      throw new IndexOutOfBoundsException();
    }
  }
}
