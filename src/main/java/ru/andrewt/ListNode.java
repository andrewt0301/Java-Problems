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
 * The {@link ListNode} class describes a node of a singly linked list.
 *
 * @param <T> Type of value stored in the node.
 *
 * @author Andrei Tatarnikov
 */
public class ListNode<T> {
  public T value;
  public ListNode next;

  public ListNode(final T value, final ListNode next) {
    this.value = value;
    this.next = next;
  }
}

