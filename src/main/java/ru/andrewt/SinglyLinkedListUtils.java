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
   * Builds an intersection of two sorted linked lists.
   *
   * @param list1 Sorted lined lists.
   * @param list2 Sorted lined lists.
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

}
