/*
 * Copyright 2018 AndrewT (https://github.com/andrewt0301)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package ru.andrewt;

import ru.andrewt.SingleLinkedList.Node;

/**
 * The {@link ListUtils} class provides utility methods to manipulate with linked lists.
 *
 * @author Andrei Tatarnikov
 */
public final class ListUtils {
  private ListUtils() {}

  /**
   * Checks whether the specified single-linked list is cyclic.
   *
   * <p>The check is based on Floyd's Tortoise and Hare algorithm. The idea is that the list
   * is traversed by two cursors with different steps (e.g. 1 and 2) until both cursors meet
   * (the list is cyclic) or the end of the list is reached (the list is non-cyclic).</p>
   *
   * @param head Head of a single-linked list.
   * @return {@code true} if the list if cyclic or {@code false} otherwise.
   */
  public static boolean isCyclic(Node head) {
    Node fast = head;
    Node slow = head;

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

  /**
   * Constructs a single-linked list on the basis of the specified array of integers.
   *
   * @param values Integer values.
   * @return Head of a single-linked list.
   */
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
