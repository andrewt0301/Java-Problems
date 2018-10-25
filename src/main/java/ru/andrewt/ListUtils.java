package ru.andrewt;

import ru.andrewt.SingleLinkedList.Node;

public final class ListUtils {
  private ListUtils() {}

  public static boolean isCyclic(Node root) {
    Node slow = root;
    Node fast = root;

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;

      if (null != fast) {
        fast = fast.next;
        if (fast == slow) {
          return true;
        }
      }
    }

    return false;
  }

}
