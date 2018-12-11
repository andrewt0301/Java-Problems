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

import org.junit.Assert;
import org.junit.Test;

/**
 * The {@link SinglyLinkedListTest} class contains tests for the {@link SinglyLinkedList} class.
 *
 * @author Andrei Tatarnikov
 */
public class SinglyLinkedListTest {
  @Test
  public void testIsEmpty() {
    Assert.assertTrue(new SinglyLinkedList().isEmpty());

    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertFalse(list.isEmpty());

    final int length = list.getLength();
    for (int count = 0; count < length; ++count) {
      Assert.assertFalse(list.isEmpty());
      list.removeAt(0);
    }

    Assert.assertTrue(list.isEmpty());
  }

  @Test
  public void testGet() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {5, 4, 3, 2, 1});
    Assert.assertArrayEquals(list.toArray(), new int[] {5, 4, 3, 2, 1});

    final int length = list.getLength();
    for (int index = 0; index < length; index++) {
      Assert.assertEquals(list.get(index), length - index);
    }
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetLowerBound() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    list.get(-1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetUpperBound() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    list.get(list.getLength());
  }

  @Test
  public void testSet() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertArrayEquals(list.toArray(), new int[] {1, 2, 3, 4, 5});

    list.set(0, 7);
    list.set(4, 9);
    Assert.assertArrayEquals(list.toArray(), new int[] {7, 2, 3, 4, 9});
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testSetLowerBound() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    list.set(-1, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testSetUpperBound() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    list.set(list.getLength(), 0);
  }

  @Test
  public void testReverse() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {5, 4, 3, 2, 1});
    Assert.assertArrayEquals(list.toArray(), new int[] {5, 4, 3, 2, 1});

    list.reverse();
    Assert.assertArrayEquals(list.toArray(), new int[] {1, 2, 3, 4, 5});
  }

  @Test
  public void testRemove() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertArrayEquals(list.toArray(), new int[] {1, 2, 3, 4, 5});

    list.removeAt(0);
    list.removeAt(3);
    list.removeAt(1);

    Assert.assertArrayEquals(list.toArray(), new int[] {2, 4});
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testRemoveLowerBound() {
    final SinglyLinkedList list = new SinglyLinkedList();
    list.removeAt(0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testRemoveUpperBound() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    list.removeAt(list.getLength());
  }

  @Test
  public void testInsert() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertArrayEquals(list.toArray(), new int[] {1, 2, 3, 4, 5});

    list.insertAt(0, 0);
    list.insertAt(6, 6);
    Assert.assertArrayEquals(list.toArray(), new int[] {0, 1, 2, 3, 4, 5, 6});

    list.insertAt(6, 66);
    list.insertAt(3, 33);
    list.insertAt(1, 11);
    Assert.assertArrayEquals(list.toArray(), new int[] {0, 11, 1, 2, 33, 3, 4, 5, 66, 6});
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testInsertLowerBound() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    list.insertAt(-1, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testInsertUpperBound() {
    final SinglyLinkedList list = new SinglyLinkedList(new int[] {1, 2, 3, 4, 5});
    list.insertAt(list.getLength() + 1, 0);
  }

  @Test
  public void testToString() {
    Assert.assertEquals(
        new SinglyLinkedList().toString(), "[]");

    Assert.assertEquals(
        new SinglyLinkedList(new int[] {1, 2, 3, 4, 5}).toString(), "[1, 2, 3, 4, 5]");
  }
}
