package ru.andrewt;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleLinkedListTest {

  @Test
  public void testSet() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertEquals(new int[] {1, 2, 3, 4, 5}, list.toArray());

    list.set(0, 7);
    list.set(4, 9);
    Assert.assertEquals(new int[] {7, 2, 3, 4, 9}, list.toArray());
  }

  @Test
  public void testReverse() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {5, 4, 3, 2, 1});
    Assert.assertEquals(new int[] {5, 4, 3, 2, 1}, list.toArray());

    list.reverse();
    Assert.assertEquals(new int[] {1, 2, 3, 4, 5}, list.toArray());
  }

  @Test
  public void testRemove() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertEquals(new int[] {1, 2, 3, 4, 5}, list.toArray());

    list.removeAt(0);
    list.removeAt(3);
    list.removeAt(1);

    Assert.assertEquals(new int[] {2, 4}, list.toArray());
  }

  @Test
  public void testInsert() {
    final SingleLinkedList list = new SingleLinkedList(new int[] {1, 2, 3, 4, 5});
    Assert.assertEquals(new int[] {1, 2, 3, 4, 5}, list.toArray());

    list.insertAt(0, 0);
    list.insertAt(6, 6);
    Assert.assertEquals(new int[] {0, 1, 2, 3, 4, 5, 6}, list.toArray());

    list.insertAt(6, 66);
    list.insertAt(3, 33);
    list.insertAt(1, 11);
    Assert.assertEquals(new int[] {0, 11, 1, 2, 33, 3, 4, 5, 66, 6}, list.toArray());
  }
}
