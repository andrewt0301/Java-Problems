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

  public static Node intersectSorted(final Node list1, final Node list2) {
    Node head = null;
    Node tail = null;

    Node node1 = list1;
    Node node2 = list2;

    while (node1 != null && node2 != null) {
      if (node1.value == node2.value) {
        Node newNode = new Node(node1.value, null);
        if (tail == null) {
          head = newNode;
        } else {
          tail.next = newNode;
        }
        tail = newNode;
      } else if (node1.value < node2.value) {
        node1 = node1.next;
      } else {
        node2 = node2.next;
      }
    }

    return head;
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

  public static Node asList(int... values) {
    Node head = null;
    Node tail = null;

    for (final int value : values) {
      final Node node = new Node(value, null);
      if (tail == null) {
        head = node;
      } else {
        tail.next = node;
      }
      tail = node;
    }

    return head;
  }

}
