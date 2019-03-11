
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

    final SinglyLinkedList<Integer> list = new SinglyLinkedList(1, 2, 3, 4, 5);
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
    final SinglyLinkedList<Integer> list = new SinglyLinkedList(5, 4, 3, 2, 1);
    Assert.assertArrayEquals(list.toArray(), new Integer[] {5, 4, 3, 2, 1});

    final int length = list.getLength();
    for (int index = 0; index < length; index++) {
      Assert.assertEquals(Integer.valueOf(length - index), list.get(index));
    }
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetLowerBound() {
    final SinglyLinkedList<Integer> list = new SinglyLinkedList(1, 2, 3, 4, 5);
    list.get(-1);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetUpperBound() {
    final SinglyLinkedList list = new SinglyLinkedList(1, 2, 3, 4, 5);
    list.get(list.getLength());
  }

  @Test
  public void testSet() {
    final SinglyLinkedList list = new SinglyLinkedList(1, 2, 3, 4, 5);
    Assert.assertArrayEquals(list.toArray(), new Integer[] {1, 2, 3, 4, 5});

    list.set(0, 7);
    list.set(4, 9);
    Assert.assertArrayEquals(list.toArray(), new Integer[] {7, 2, 3, 4, 9});
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testSetLowerBound() {
    final SinglyLinkedList list = new SinglyLinkedList(1, 2, 3, 4, 5);
    list.set(-1, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testSetUpperBound() {
    final SinglyLinkedList list = new SinglyLinkedList(1, 2, 3, 4, 5);
    list.set(list.getLength(), 0);
  }

  @Test
  public void testReverse() {
    final SinglyLinkedList list = new SinglyLinkedList(5, 4, 3, 2, 1);
    Assert.assertArrayEquals(list.toArray(), new Integer[] {5, 4, 3, 2, 1});

    list.reverse();
    Assert.assertArrayEquals(list.toArray(), new Integer[] {1, 2, 3, 4, 5});
  }

  @Test
  public void testRemove() {
    final SinglyLinkedList<Integer> list = new SinglyLinkedList(1, 2, 3, 4, 5);
    Assert.assertArrayEquals(list.toArray(), new Integer[] {1, 2, 3, 4, 5});

    list.removeAt(0);
    list.removeAt(3);
    list.removeAt(1);

    Assert.assertArrayEquals(list.toArray(), new Integer[] {2, 4});
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
    final SinglyLinkedList<Integer> list = new SinglyLinkedList(1, 2, 3, 4, 5);
    Assert.assertArrayEquals(list.toArray(), new Integer[] {1, 2, 3, 4, 5});

    list.insertAt(0, 0);
    list.insertAt(6, 6);
    Assert.assertArrayEquals(list.toArray(), new Integer[] {0, 1, 2, 3, 4, 5, 6});

    list.insertAt(6, 66);
    list.insertAt(3, 33);
    list.insertAt(1, 11);
    Assert.assertArrayEquals(list.toArray(), new Integer[] {0, 11, 1, 2, 33, 3, 4, 5, 66, 6});
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testInsertLowerBound() {
    final SinglyLinkedList<Integer> list = new SinglyLinkedList(1, 2, 3, 4, 5);
    list.insertAt(-1, 0);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testInsertUpperBound() {
    final SinglyLinkedList<Integer> list = new SinglyLinkedList(1, 2, 3, 4, 5);
    list.insertAt(list.getLength() + 1, 0);
  }

  @Test
  public void testGetFirstGetLast() {
    final SinglyLinkedList<Integer> list = new SinglyLinkedList(1, 2, 3, 4, 5);
    Assert.assertEquals(Integer.valueOf(1), list.getFirst());
    Assert.assertEquals(Integer.valueOf(5), list.getLast());
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetFirst() {
    final SinglyLinkedList<Integer> list = new SinglyLinkedList();
    list.getFirst();
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetLast() {
    final SinglyLinkedList<Integer> list = new SinglyLinkedList();
    list.getLast();
  }

  @Test
  public void testToString() {
    Assert.assertEquals(
        new SinglyLinkedList().toString(), "[]");

    Assert.assertEquals(
        new SinglyLinkedList<>(1, 2, 3, 4, 5).toString(), "[1, 2, 3, 4, 5]");
  }

}
