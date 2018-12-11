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

import java.util.Arrays;

/**
 * The {@link ArrayUtilsTest} class contains tests for the {@link ArrayUtils} class methods.
 *
 * @author Andrei Tatarnikov
 */
public class ArrayUtilsTest {

    @Test
    public void testSwap() {
        final int[] initial = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        final int[] array = Arrays.copyOf(initial, initial.length);

        ArrayUtils.swap(array, 1, 8);
        Assert.assertArrayEquals(new int[] {0, 8, 2, 3, 4, 5, 6, 7, 1, 9}, array);

        ArrayUtils.swap(array, 8, 1);
        Assert.assertArrayEquals(initial, array);

        ArrayUtils.swap(array, 0, 9);
        Assert.assertArrayEquals(new int[] {9, 1, 2, 3, 4, 5, 6, 7, 8, 0}, array);

        ArrayUtils.swap(array, 9, 0);
        Assert.assertArrayEquals(initial, array);
    }

    @Test
    public void testNewArray() {
        final Object[] nulls = new Object[] {null, null, null, null, null};

        String[] strings = ArrayUtils.newArray(nulls.length);
        Assert.assertArrayEquals(nulls, strings);

        Integer[] integers = ArrayUtils.newArray(nulls.length);
        Assert.assertArrayEquals(nulls, integers);

        // Needed to ensure that newArray correctly casts user-defined types.
        class A { }

        A[] objects = ArrayUtils.newArray(nulls.length);
        Assert.assertArrayEquals(nulls, objects);
    }

    @Test
    public void testShiftHigh() {
        final int[] initial = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] array = Arrays.copyOf(initial, initial.length);
        ArrayUtils.shiftHigh(array, 0, 3);
        Assert.assertArrayEquals(new int[] {0, 0, 1, 2, 4, 5, 6, 7, 8, 9}, array);

        array = Arrays.copyOf(initial, initial.length);
        ArrayUtils.shiftHigh(array, 6, 3);
        Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 6, 7, 8}, array);

        array = Arrays.copyOf(initial, initial.length);
        ArrayUtils.shiftHigh(array, 3, 5);
        Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 3, 4, 5, 6, 7, 9}, array);
    }

    @Test
    public void testShiftLow() {
        final int[] initial = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] array = Arrays.copyOf(initial, initial.length);
        ArrayUtils.shiftLow(array, 1, 3);
        Assert.assertArrayEquals(new int[] {1, 2, 3, 3, 4, 5, 6, 7, 8, 9}, array);

        array = Arrays.copyOf(initial, initial.length);
        ArrayUtils.shiftLow(array, 7, 3);
        Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 7, 8, 9, 9}, array);

        array = Arrays.copyOf(initial, initial.length);
        ArrayUtils.shiftLow(array, 3, 5);
        Assert.assertArrayEquals(new int[] {0, 1, 3, 4, 5, 6, 7, 7, 8, 9}, array);
    }

    @Test
    public void testMove() {
        final int[] array = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        ArrayUtils.move(array, 0, 9);
        Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, array);

        ArrayUtils.move(array, 9, 0);
        Assert.assertArrayEquals(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, array);

        ArrayUtils.move(array, 3, 5);
        Assert.assertArrayEquals(new int[] {0, 1, 2, 4, 5, 3, 6, 7, 8, 9}, array);
    }

}
