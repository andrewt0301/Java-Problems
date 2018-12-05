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
 * The {@link SingleLinkedList} class implements the single-linked list data structure.
 *
 * @author Andrei Tatarnikov
 */
public final class SingleLinkedList {

  public static final class Node {
    public int value;
    public Node next;

    public Node(final int value, final Node next) {
      this.value = value;
      this.next = next;
    }
  }

  Node head;
  Node tail;
  int length;

  public SingleLinkedList() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  public SingleLinkedList(final int[] data) {
    this();
    for (int index = 0; index < data.length; index++) {
      add(data[index]);
    }
  }

  public boolean isEmpty() {
    return length == 0;
  }

  public int getLength() {
    return length;
  }

  public void add(final int value) {
    final Node node = new Node(value, null);
    if (tail == null) {
      head = node;
    } else {
      tail.next = node;
    }
    tail = node;
    length++;
  }

  public int get(final int index) {
    checkBounds(index);

    Node node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }

    return node.value;
  }

  public void set(final int index, final int value) {
    checkBounds(index);

    Node node = head;
    for (int i = 0; i < index; i++) {
      node = node.next;
    }

    node.value = value;
  }

  public void insertAt(final int index, final int value) {
    if (index == length) {
      add(value);
      return;
    }

    checkBounds(index);

    Node prev = null;
    Node curr = head;

    for (int i = 0; i < index; i++) {
      prev = curr;
      curr = curr.next;
    }

    final Node node = new Node(value, curr);

    if (prev == null) {
      head = node;
    } else {
      prev.next = node;
    }

    length++;
  }

  public void removeAt(final int index) {
    checkBounds(index);

    Node prev = null;
    Node curr = head;

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
    Node newHead = null;
    Node curr = head;

    while (curr != null) {
      final Node node = curr;
      curr = curr.next;

      node.next = newHead;
      newHead = node;
    }

    head = newHead;
  }

  public int[] toArray() {
    final int[] array = new int[length];

    int index = 0;
    for (Node curr = head; curr != null; curr = curr.next) {
      array[index++] = curr.value;
    }

    return array;
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append('[');

    for (Node curr = head; curr != null; curr = curr.next) {
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
