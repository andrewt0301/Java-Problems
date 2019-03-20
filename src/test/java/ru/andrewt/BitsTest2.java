
package ru.andrewt;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for methods of the {@link Bits} class.
 *
 * @author Andrei Tatarnikov
 */
public class BitsTest2 {

  @Test
  public void testGetBitCount() {

    final int[][] testData = {
        {0,   0},
        {1,   1},
        {-1, 32},
        {15,  4},
        {60,  4},
        {240, 4},
        {0xDEADBEEF, 24}
    };

    for (int[] testCase : testData) {
      final int value = testCase[0];
      final int count = testCase[1];

      Assert.assertEquals(count, Bits.getBitCount(value));
    }
  }

}
