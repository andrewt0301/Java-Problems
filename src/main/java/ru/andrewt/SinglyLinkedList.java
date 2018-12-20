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
 * The {@link SinglyLinkedList} class implements the singly linked list data structure.
 *
 * @param <T> Type of elements stored in the list.
 *
 * @author Andrei Tatarnikov
 */
public final class SinglyLinkedList<T> {

  ListNode<T> head;
  ListNode<T> tail;
  int length;

  public SinglyLinkedList() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public SinglyLinkedList(final T... values) {
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
    final ListNode<T> node = new ListNode<>(value, null);
    if (tail == null) {
      head = node;
    } else {
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

  private ListNode<T> getNode(final int index) {
    checkBounds(index);

    ListNode<T> node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }

    return node;
  }

  public void insertAt(final int index, final T value) {
    if (index == length) {
      add(value);
      return;
    }

    checkBounds(index);

    ListNode<T> prev = null;
    ListNode<T> curr = head;

    for (int i = 0; i < index; i++) {
      prev = curr;
      curr = curr.next;
    }

    final ListNode<T> node = new ListNode<>(value, curr);

    if (prev == null) {
      head = node;
    } else {
      prev.next = node;
    }

    length++;
  }

  public void removeAt(final int index) {
    checkBounds(index);

    ListNode<T> prev = null;
    ListNode<T> curr = head;

    for (int i = 0; i < index; i++) {
      prev = curr;
      curr = curr.next;
    }

    if (prev == null) {
      head = head.next;
    } else {
      prev.next = prev.next.next;
    }

    if (curr == tail) {
      tail = prev;
    }

    length--;
  }

  public void reverse() {
    ListNode<T> newHead = null;
    ListNode<T> curr = head;

    while (curr != null) {
      final ListNode<T> node = curr;
      curr = curr.next;

      node.next = newHead;
      newHead = node;
    }

    head = newHead;
  }

  public T[] toArray() {
    final T[] array = ArrayUtils.newArray(length);

    int index = 0;
    for (ListNode<T> curr = head; curr != null; curr = curr.next) {
      array[index++] = curr.value;
    }

    return array;
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append('[');

    for (ListNode<T> curr = head; curr != null; curr = curr.next) {
      if (curr != head) {
        builder.append(", ");
      }
      builder.append(curr.value);
    }

    builder.append(']');
    return builder.toString();
  }

  private void checkBounds(final int index) {
    if (!(0 <= index && index < length)) {
      throw new IndexOutOfBoundsException();
    }
  }
}
