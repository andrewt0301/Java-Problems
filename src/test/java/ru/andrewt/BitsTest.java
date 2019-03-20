
package ru.andrewt;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Tests for the {@link Bits#isPowerOfTwo} method.
 *
 * @author Andrei Tatarnikov
 */
@RunWith(Parameterized.class)
public class BitsTest {
  @Parameterized.Parameter()
  public int input;

  @Parameterized.Parameter(1)
  public boolean expected;

  @Parameterized.Parameters(name = "{index}: Bits.isPowerOfTwo({0}) == {1}")
  public static Collection<Object[]> data() {
    final int testCount = Integer.SIZE * 2;
    final Collection<Object[]> data = new ArrayList<>(testCount);

    for (int value = 1; value != 0; value <<= 1) {
      data.add(new Object[] {value, true});
      data.add(new Object[] {value != 1 ? value + 1 : value - 1, false});
    }

    return data;
  }

  @Test
  public void testIsPowerOfTwo() {
    Assert.assertEquals(Bits.isPowerOfTwo(input), expected);
  }
}
