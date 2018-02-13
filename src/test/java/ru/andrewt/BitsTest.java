package ru.andrewt;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BitsTest {
  @DataProvider(name = "isPowerOfTwo")
  public static Object[][] isPowerOfTwo() {
    final int testCount = Integer.SIZE * 2;

    final Object[][] data = new Object[testCount][];

    int index = 0;
    for (int value = 1; value != 0; value = value << 1) {
      data[index++] = new Object[] {value, true};
      data[index++] = new Object[] {value != 1 ? value + 1 : value - 1, false};
    }

    return data;


  }

  @Test(description = "ddd", dataProvider = "isPowerOfTwo")
  public void testIsPowerOfTwo(final int input, final boolean expected) throws Exception {
    Assert.assertEquals(Bits.isPowerOfTwo(input), expected);
  }
}
