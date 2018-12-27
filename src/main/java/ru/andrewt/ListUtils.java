
package ru.andrewt;

/**
 * The {@link ListUtils} class provides utility methods to manipulate with linked lists.
 *
 * @author Andrei Tatarnikov
 */
public final class ListUtils {
  private ListUtils() {}

  /**
   * Checks whether the specified singly inked list is cyclic.
   *
   * <p>The check is based on Floyd's Tortoise and Hare algorithm. The idea is that the list
   * is traversed by two cursors with different steps (e.g. 1 and 2) until both cursors meet
   * (the list is cyclic) or the end of the list is reached (the list is non-cyclic).</p>
   *
   * @param head Head of a singly linked list.
   * @param <T> Type of values stored in the list.
   * @return {@code true} if the list if cyclic or {@code false} otherwise.
   */
  public static <T> boolean isCyclic(ListNode<T> head) {
    ListNode<T> fast = head;
    ListNode<T> slow = head;

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;

      if (fast != null) {
        fast = fast.next;
        if (fast == slow) {
          return true;
        }
      }
    }

    return false;
  }

  /**
   * Builds an intersection of two sorted singly linked lists.
   *
   * @param list1 Sorted lined lists.
   * @param list2 Sorted lined lists.
   * @param <T> Type of values stored in the list.
   * @return Intersection of two lists (sorted linked list).
   */
  public static <T extends Comparable<T>> ListNode<T> intersectSorted(
      final ListNode<T> list1,
      final ListNode<T> list2) {
    ListNode<T> node1 = list1;
    ListNode<T> node2 = list2;

    ListNode<T> head = null;
    ListNode<T> tail = null;

    while (node1 != null && node2 != null) {
      if (node1.value == node2.value) {
        final ListNode<T> newNode = new ListNode<>(node1.value, null);
        if (null == tail) {
          head = newNode;
        }
        tail = newNode;

        node1 = node1.next;
        node2 = node2.next;
      } else if (node1.value.compareTo(node2.value) < 0) {
        node1 = node1.next;
      } else {
        node2 = node2.next;
      }
    }

    return head;
  }

  /**
   * Creates a singly linked list with a cycle on the specified node.
   * Node values are integer numbers in the range {@code [0..length-1]}.
   *
   * @param length List length.
   * @param cycleIndex Index of a node with a cycle (pointed by two other nodes).
   * @return Singly linked list with a cycle.
   */
  public static ListNode<Integer> newCyclicList(final int length, final int cycleIndex) {
    ListNode<Integer> head = null;
    ListNode<Integer> tail = null;
    ListNode<Integer> cycle = null;

    for (int index = length - 1; index >= 0; --index) {
      final ListNode<Integer> node = new ListNode<>(index, head);

      if (head == null) {
        tail = node;
      }

      if (index == cycleIndex) {
        cycle = node;
      }

      head = node;
    }

    if (cycle != null) {
      tail.next = cycle;
    }

    return head;
  }

  /**
   * Saves a linked list into an array.
   *
   * @param head Head of the linked list.
   * @param length Length of the list.
   * @param <T> Type of values stored in the list.
   * @return Array of elements stored in the list.
   */
  public static <T> T[] toArray(final ListNode<T> head, final int length) {
    final T[] array = ArrayUtils.newArray(length);

    int index = 0;
    for (ListNode<T> curr = head; curr != null; curr = curr.next) {
      array[index++] = curr.value;
    }

    return array;
  }

  /**
   * Prints a linked list to a string.
   *
   * @param head Head of the linked list.
   * @param <T> Type of values stored in the list.
   * @return String representation of the list.
   */
  public static <T> String toString(final ListNode<T> head) {
    final StringBuilder builder = new StringBuilder();
    builder.append('[');

    for (ListNode<T> node = head; node != null; node = node.next) {
      if (node != head) {
        builder.append(", ");
      }
      builder.append(node.value);
    }

    builder.append(']');
    return builder.toString();
  }

}
