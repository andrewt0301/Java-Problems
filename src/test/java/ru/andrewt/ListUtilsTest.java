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

import ru.andrewt.SinglyLinkedList.Node;

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

      Node list = ListUtils.newCyclicList(length, cycleIndex);
      boolean cyclic = ListUtils.isCyclic(list);

      Assert.assertEquals(expected, cyclic);
    }
  }

  @Test
  public void test_intersectSorted() {
    Node list1 = ListUtils.asList(3, 5, 7, 8, 10, 13, 14, 15);
    Node list2 = ListUtils.asList(2, 4, 5, 6,  8, 11, 13, 15);

    Node list3 = ListUtils.intersectSorted(list1, list2);
    Node head = list3;

    final StringBuilder builder = new StringBuilder();
    builder.append('[');

    for (Node curr = head; curr != null; curr = curr.next) {
      if (curr != head) {
        builder.append(", ");
      }
      builder.append(curr.value);
    }

    builder.append(']');
    System.out.println(builder.toString());

  }

}
