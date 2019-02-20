
package ru.andrewt;

import org.junit.Test;

import java.util.Arrays;

/**
 * Tests for the methods of the {@link Searching} class.
 *
 * @author Andrei Tatarnikov
 */
public class SearchingTest {

  @Test
  public void testFindMaxSubarray() {
    // TODO
    int[] data = {1, 2, 4, -10};
    int[] x = Searching.findMaxSubarray(data);
    System.out.println(Arrays.toString(x));
  }

}
