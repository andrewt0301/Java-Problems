package ru.andrewt;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleLinkedListTest {
  @Test
  public void testIsEmpty() {
    Assert.assertTrue(new SingleLinkedList().isEmpty());

    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertFalse(list.isEmpty());

    final int length = list.getLength();
    for (int count = 0; count < length; ++count) {
      Assert.assertFalse(list.isEmpty());
      list.removeAt(0);
    }

    Assert.assertTrue(list.isEmpty());
  }

  @Test
  public void testSet() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertEquals(list.toArray(), new int[] {1, 2, 3, 4, 5});

    list.set(0, 7);
    list.set(4, 9);
    Assert.assertEquals(list.toArray(), new int[] {7, 2, 3, 4, 9});
  }

  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void testSetLowerBound() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    new SingleLinkedList().set(-1, 0);
  }

  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void testSetUpperBound() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    list.set(list.getLength(), 0);
  }

  @Test
  public void testReverse() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {5, 4, 3, 2, 1});
    Assert.assertEquals(list.toArray(), new int[] {5, 4, 3, 2, 1});

    list.reverse();
    Assert.assertEquals(list.toArray(), new int[] {1, 2, 3, 4, 5});
  }

  @Test
  public void testRemove() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertEquals(list.toArray(), new int[] {1, 2, 3, 4, 5});

    list.removeAt(0);
    list.removeAt(3);
    list.removeAt(1);

    Assert.assertEquals(list.toArray(), new int[] {2, 4});
  }

  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void testRemoveLowerBound() {
    final SingleLinkedList list = new SingleLinkedList();
    new SingleLinkedList().removeAt(0);
  }

  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void testRemoveUpperBound() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    list.removeAt(list.getLength());
  }

  @Test
  public void testInsert() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertEquals(list.toArray(), new int[] {1, 2, 3, 4, 5});

    list.insertAt(0, 0);
    list.insertAt(6, 6);
    Assert.assertEquals(list.toArray(), new int[] {0, 1, 2, 3, 4, 5, 6});

    list.insertAt(6, 66);
    list.insertAt(3, 33);
    list.insertAt(1, 11);
    Assert.assertEquals(list.toArray(), new int[] {0, 11, 1, 2, 33, 3, 4, 5, 66, 6});
  }

  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void testInsertLowerBound() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    new SingleLinkedList().insertAt(-1, 0);
  }

  @Test(expectedExceptions = IndexOutOfBoundsException.class)
  public void testInsertUpperBound() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    list.insertAt(list.getLength() + 1, 0);
  }

  @Test
  public void testToString() {
    Assert.assertEquals(
        new SingleLinkedList().toString(), "[]");

    Assert.assertEquals(
        new SingleLinkedList(new int[] {1, 2, 3, 4, 5}).toString(), "[1, 2, 3, 4, 5]");
  }
}
