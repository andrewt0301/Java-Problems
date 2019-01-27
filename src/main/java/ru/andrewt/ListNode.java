
package ru.andrewt;

/**
 * The {@link ListNode} class describes a node of a singly linked list.
 *
 * @param <T> Type of value stored in the node.
 *
 * @author Andrei Tatarnikov
 */
public class ListNode<T> {
  public T value;
  public ListNode<T> next;

  public ListNode(final T value, final ListNode<T> next) {
    this.value = value;
    this.next = next;
  }
}

