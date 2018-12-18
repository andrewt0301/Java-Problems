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

/**
 * The {@link Bits} class provides utility methods for various bit manipulations.
 *
 * @author Andrei Tatarnikov
 */
public final class Bits {
  private Bits() {}

  /**
   * Checks whether the specified integer value is a power of two.
   *
   * @param value Integer value.
   * @return {@code true} if the value is a power of two or {@code false} otherwise.
   */
  public static boolean isPowerOfTwo(final int value) {
    return value != 0 && (value & value - 1) == 0;
  }

}
