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

import java.util.Arrays;

/**
 * The {@link Utils} class provides utility methods to manipulate with arrays.
 */
public final class Utils {
  private Utils() {}

  /**
   * Swaps two elements in an array.
   *
   * @param a Array.
   * @param i First element.
   * @param j Second element.
   */
  public static void swap(final int[] a, final int i, final int j) {
    final int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  /**
   * Creates a new array of the specified type and length. Optionally copies the
   * specified values into the created array.
   *
   * <p>Implemented to be able to create typed arrays. The {@code old} parameter is declared
   * mainly to be able to specify element type (hack to overcome some language limitations).
   * Normally, it is not used.</p>
   *
   * @param length Array length.
   * @param old (optional) Values to be placed into the array.
   * @param <T> Array element type.
   * @return Array of the specified type and length.
   */
  public static <T> T[] newArray(final int length, final T ... old) {
    return Arrays.copyOf(old, length);
  }

}
