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

import ru.andrewt.SinglyLinkedList.Node;

/**
 * The {@link SinglyLinkedListUtils} class provides utility methods to manipulate
 * with singly linked lists.
 *
 * @author Andrei Tatarnikov
 */
public final class SinglyLinkedListUtils {
  private SinglyLinkedListUtils() {}

  /**
   * Checks whether the specified singly inked list is cyclic.
   *
   * <p>The check is based on Floyd's Tortoise and Hare algorithm. The idea is that the list
   * is traversed by two cursors with different steps (e.g. 1 and 2) until both cursors meet
   * (the list is cyclic) or the end of the list is reached (the list is non-cyclic).</p>
   *
   * @param head Head of a singly linked list.
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

  /**
   * Builds an intersection of two sorted linked lists.
   *
   * @param list1 Sorted lined lists.
   * @param list2 Sorted lined lists.
   * @return Intersection of two lists (sorted linked list).
   */
  public static Node intersectSorted(final Node list1, final Node list2) {
    SinglyLinkedList result = new SinglyLinkedList();

    Node node1 = list1;
    Node node2 = list2;

    while (node1 != null && node2 != null) {
      if (node1.value == node2.value) {
        result.add(node1.value);

        node1 = node1.next;
        node2 = node2.next;
      } else if (node1.value < node2.value) {
        node1 = node1.next;
      } else {
        node2 = node2.next;
      }
    }

    return result.head;
  }


  /**
   * Creates a singly linked list with a cycle on the specified node.
   * Node values are numbers in the range {@code [0..length-1]}.
   *
   * @param length List length.
   * @param cycleIndex Index of a node with a cycle (pointed by two other nodes).
   * @return Singly linked list with a cycle.
   */
  public static Node newCyclicList(final int length, final int cycleIndex) {
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
   * Constructs a singly linked list on the basis of the specified array of integers.
   *
   * @param values Integer values.
   * @return Head of a singly linked list.
   */
  public static Node asList(final int... values) {
    return new SinglyLinkedList(values).head;
  }

}
