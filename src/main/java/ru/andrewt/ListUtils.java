package ru.andrewt;

import ru.andrewt.SingleLinkedList.Node;

public final class ListUtils {
  private ListUtils() {}

  public static boolean isCyclic(Node root) {
    Node fast = root;
    Node slow = root;

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

  public static Node newList(final int length, final int cycleIndex) {
    Node head = null;
    Node tail = null;
    Node cycle = null;

    for (int index = length - 1; index >= 0; --index) {
      final Node node = new Node(index, head);

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

}
