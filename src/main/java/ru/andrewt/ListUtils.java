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

}
