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
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

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

    int index = 0;
    for (int value = 1; value != 0; value = value << 1) {
      data.add(new Object[] {value, true});
      data.add(new Object[] {value != 1 ? value + 1 : value - 1, false});
    }

    return data;
  }

  @Test
  public void testIsPowerOfTwo() throws Exception {
    Assert.assertEquals(Bits.isPowerOfTwo(input), expected);
  }
}
