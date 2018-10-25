
package ru.andrewt;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import ru.andrewt.SingleLinkedList.Node;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ListUtilsTest {
  @Parameterized.Parameters(name = "isCyclic(List({0},{1}) = {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
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
        { 13, 12, true  },
    });
  }

  @Parameterized.Parameter(0)
  public int length;

  @Parameterized.Parameter(1)
  public int cycleIndex;

  @Parameterized.Parameter(2)
  public boolean isCyclic;

  @Test
  public void test() {
    Node list = ListUtils.newList(length, cycleIndex);
    boolean cyclic = ListUtils.isCyclic(list);
    Assert.assertEquals(isCyclic, cyclic);
  }
}
