
package ru.andrewt.tasks;

import org.junit.Assert;
import org.junit.Test;

/**
 * The {@link TasksTest} class contains tests for the {@link Tasks} class methods.
 *
 * @author Andrei Tatarnikov
 */
public class TasksTest {

  @Test
  public void testLengthOfLongestSubarray() {

    // The sub-array is { 5, 2, 7, 1 }.
    Assert.assertEquals(
        4,
        Tasks.lengthOfLongestSubarray(new int[] { 10, 5, 2, 7, 1, 9 }, 15));

    // The sub-array is { -5, 8, -14, 2, 4 }.
    Assert.assertEquals(
        5,
        Tasks.lengthOfLongestSubarray(new int[] { 1, -5, 8, -14, 2, 4, 12 }, -5));

  }

}
