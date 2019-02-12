
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

  private Node<T> getNode(final int index) {
    checkBounds(index);

    Node<T> node;
    if (index < length / 2) {
      // Looking up from head.
      node = head;
      for (int i = 0; i < index; i++) {
        node = (Node<T>) node.next;
      }
    } else {
      // Looking up from tail.
      node = tail;
      for (int i = length - 1; i > index; i--) {
        node = node.prev;
      }
    }
    return node;
  }

  public void insertAt(final int index, final T value) {

    if (index == length) {
      add(value);
      return;
    }

    if (index == 0) {
      head = new Node<>(value, null, head);
    } else {
      Node<T> node = getNode(index);
      Node<T> newNode = new Node<>(value, node.prev, node);

      node.prev.next = newNode;
      node.prev = newNode;
    }

    length++;
  }

  public void removeAt(final int index) {
    Node<T> node = getNode(index);

    if (node == head) {
      head = (Node<T>) head.next;
    } else {
      node.prev.next = node.next;
    }

    if (node == tail) {
      tail = node.prev;
    } else {
      ((Node<T>) node.next).prev = (Node<T>) node.next;
    }

    length--;
  }

  public T getFirst() {
    if (head == null) {
      throw new IndexOutOfBoundsException();
    }
    return head.value;
  }

  public T getLast() {
    if (tail == null) {
      throw new IndexOutOfBoundsException();
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

  private void checkBounds(final int index) {
    if (!(0 <= index && index < length)) {
      throw new IndexOutOfBoundsException();
    }
  }

}
