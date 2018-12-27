
package ru.andrewt;

import org.junit.Assert;
import org.junit.Test;

/**
 * The {@link ListUtilsTest} class contains tests for the {@link ListUtils}
 * class methods.
 *
 * @author Andrei Tatarnikov
 */
public class ListUtilsTest {

  @Test
  public void test_isCyclic() {
    final Object[][] data = new Object[][] {
        {  0,  0, false },
        {  1, -1, false },
        {  5, -1, false },
        { 10, -1, false },
        {  1,  0, true  },
        {  1,  1, false },
        {  2,  1, true  },
        { 10,  5, true  },
        { 13,  8, true  },
        { 13,  1, true  },
        { 13, 12, true  }
    };

    for (final Object[] dataItem : data) {
      int length = (int) dataItem[0];
      int cycleIndex = (int) dataItem[1];
      boolean expected = (boolean) dataItem[2];

      ListNode<Integer> list = ListUtils.newCyclicList(length, cycleIndex);
      boolean cyclic = ListUtils.isCyclic(list);

      Assert.assertEquals(expected, cyclic);
    }
  }

  @Test
  public void testIntersectSorted() {
    ListNode<Integer> list1 = asList(3, 5, 7, 8, 10, 13, 14, 15);
    ListNode<Integer> list2 = asList(2, 4, 5, 6,  8, 11, 13, 15);

    ListNode<Integer> list3 = ListUtils.intersectSorted(list1, list2);
    ListNode<Integer> head = list3;

    final StringBuilder builder = new StringBuilder();
    builder.append('[');

    for (ListNode<Integer> curr = head; curr != null; curr = curr.next) {
      if (curr != head) {
        builder.append(", ");
      }
      builder.append(curr.value);
    }

    builder.append(']');
    System.out.println(builder.toString());
  }

  /**
   * Constructs a singly linked list on the basis of the specified array of integers.
   *
   * @param values Integer values.
   * @param <T> Type of values stored in the list.
   * @return Head of a singly linked list.
   */
  public static <T> ListNode<T> asList(final T... values) {
    return new SinglyLinkedList<>(values).head;
  }

}
