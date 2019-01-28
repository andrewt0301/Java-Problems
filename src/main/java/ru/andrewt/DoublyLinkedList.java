
package ru.andrewt;

/**
 * The {@link DoublyLinkedList} class implements the doubly linked list data structure.
 *
 * @param <T> Type of elements stored in the list.
 *
 * @author Andrei Tatarnikov
 */
public class DoublyLinkedList<T> {

  /**
   * The {@link Node} class describes a node of a doubly linked list.
   *
   * @param <T> Type of value stored in the node.
   *
   * @author Andrei Tatarnikov
   */
  public class Node<T> extends ListNode<T> {
    public Node<T> prev;

    public Node(final T value, final Node<T> prev, final Node<T> next) {
      super(value, next);
      this.prev = prev;
    }
  }

  protected Node<T> head;
  protected Node<T> tail;
  protected int length;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public DoublyLinkedList(final T... values) {
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
    final Node<T> node = new Node<>(value, null, null);

    if (tail == null) {
      head = node;
    } else {
      node.prev = tail;
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

    if (index < length / 2) {
      // Looking up from head.
      ListNode<T> node = head;
      for (int i = 0; i < index; i++) {
        node = node.next;
      }
      return node;
    } else {
      // Looking up from tail.
      Node<T> node = tail;
      for (int i = length - 1; i > index; i--) {
        node = node.prev;
      }
      return node;
    }
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
