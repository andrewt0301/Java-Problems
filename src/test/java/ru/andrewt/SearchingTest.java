
package ru.andrewt;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Tests for the methods of the {@link Searching} class.
 *
 * @author Andrei Tatarnikov
 */
public class SearchingTest {

  @Test
  public void testLinearSearch() {
    final int data[] = { 1, 3, 5, 2, 4, -1, 0, 1, -2, 6, -3, 7 };

    // Missing keys.
    Assert.assertEquals(-1, Searching.linearSearch(data, 10));
    Assert.assertEquals(-1, Searching.linearSearch(data, -10));

    // First and last.
    Assert.assertEquals(0, Searching.linearSearch(data, 1));
    Assert.assertEquals(data.length -1, Searching.linearSearch(data, 7));

    // Middle.
    Assert.assertEquals(6, Searching.linearSearch(data, 0));
    Assert.assertEquals(8, Searching.linearSearch(data, -2));
  }

  @Test
  public void testMinAndMax() {
    final int data[] = { 1, 3, 5, 2, 4, -1, 0, 1, -2, 6, -3, 7 };

    Assert.assertEquals(-3, Searching.min(data));
    Assert.assertEquals(7, Searching.max(data));
    Assert.assertArrayEquals(new int[]{-3, 7}, Searching.minAndMax(data));
  }

  @Test
  public void testFindMaxSubarray() {
    // TODO
    int[] data = {1, 2, 4, -10, 5, 9, 0, -1, 3, -5 };
    int[] x = Searching.findMaxSubarray(data);
    System.out.println(Arrays.toString(x));
  }

}
