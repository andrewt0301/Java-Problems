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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * The {@link TreeMapTest} class contains tests for the {@link TreeMap} class.
 *
 * @author Andrei Tatarnikov
 */
public class TreeMapTest {

  @Test
  public void testTreeMap() {
    final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    Assert.assertTrue(treeMap.isEmpty());
    Assert.assertEquals(0, treeMap.size());
  }

  @Test
  public void testPut() {
    final Consumer<Integer[]> test = keys -> {
      Integer[] sortedKeys = Arrays.copyOf(keys, keys.length);
      Arrays.sort(sortedKeys);

      final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
      for (Integer key : keys) {
        treeMap.put(key, key * 2);
      }

      Assert.assertTrue(treeMap.isEmpty() == (keys.length == 0));
      Assert.assertEquals(sortedKeys.length, treeMap.size());
      Assert.assertArrayEquals(sortedKeys, treeMap.getKeys());
    };

    // Keys are put in the descending order.
    test.accept(new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});

    // Keys are put in the ascending order.
    test.accept(new Integer[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0});

    // Half of keys is put in the ascending order and
    // another half is put in the descending order.
    test.accept(new Integer[] {0, 1, 2, 3, 4, 9, 8, 7, 6, 5});

    // Keys are put in an arbitrary order.
    test.accept(new Integer[] {0, 5, 1, 6, 2, 7, 3, 8, 4, 9});
    test.accept(new Integer[] {9, 0, 8, 1, 7, 2, 6, 3, 5, 4});

    // Keys are put in a random order (deterministic).
    final Collection<Integer> keys = newShuffledSet(0, 9, 13);
    test.accept(keys.toArray(new Integer[keys.size()]));
  }

  @Test
  public void testPutUpdate() {
    final int min = -10;
    final int max = 10;

    final TreeMap<Integer, Integer> treeMap = newTreeMapForRange(min, max);

    // Updates all key values.
    Object[] keys = treeMap.getKeys();
    for (int index = 0; index < keys.length; ++index) {
      final Integer key = (Integer) keys[index];
      final Integer value = treeMap.get(key);

      Assert.assertEquals(value, key);
      treeMap.put(key, value * 2);
    }

    // Checks all values in the range.
    for (int index = min; index <= max; ++index) {
      final int value = treeMap.get(index);
      Assert.assertEquals(value, index * 2);
    }
  }

  @Test
  public void testMinMax() {
    final int min = -10;
    final int max = 10;

    final TreeMap<Integer, Integer> treeMap = newTreeMapForRange(min, max);

    final int minValue = treeMap.min();
    final int maxValue = treeMap.max();

    Assert.assertEquals(min, minValue);
    Assert.assertEquals(max, maxValue);
  }

  @Test
  public void testSuccessorPredecessor() {
    final int min = -10;
    final int max = 10;

    final TreeMap<Integer, Integer> treeMap = newTreeMapForRange(min, max);

    // Corner cases.
    Assert.assertTrue(treeMap.getPredecessor(max) == (max - 1));
    Assert.assertTrue(treeMap.getSuccessor(max) == null);
    Assert.assertTrue(treeMap.getPredecessor(min) == null);
    Assert.assertTrue(treeMap.getSuccessor(min) == (min + 1));

    // Beyond the bounds.
    Assert.assertTrue(null == treeMap.getPredecessor(min - 1));
    Assert.assertTrue(null == treeMap.getSuccessor(max + 1));

    // All other cases withing the bounds.
    for (int key = min + 1; key < max; ++key) {
      final Integer successor = treeMap.getSuccessor(key);
      final Integer predecessor = treeMap.getPredecessor(key);

      Assert.assertTrue((key + 1) == successor);
      Assert.assertTrue((key - 1) == predecessor);
    }
  }

  @Test
  public void testContains() {
    final int min = -10;
    final int max = 10;

    final TreeMap<Integer, Integer> treeMap = newTreeMapForRange(min, max);

    for (int index = min; index <= max; ++index) {
      Assert.assertTrue(treeMap.contains(index));
    }

    Assert.assertFalse(treeMap.contains(min - 1));
    Assert.assertFalse(treeMap.contains(max + 1));
    Assert.assertFalse(treeMap.contains(Integer.MIN_VALUE));
    Assert.assertFalse(treeMap.contains(Integer.MAX_VALUE));
    Assert.assertFalse(treeMap.contains(null));
  }

  @Test
  public void testRemove() {
    final int min = -20;
    final int max = 20;

    final TreeMap<Integer, Integer> treeMap = newTreeMapForRange(min, max);

    Assert.assertTrue(null == treeMap.remove(null));
    Assert.assertTrue(null == treeMap.remove(min - 1));
    Assert.assertTrue(null == treeMap.remove(max + 1));
    Assert.assertTrue(null == treeMap.remove(Integer.MIN_VALUE));
    Assert.assertTrue(null == treeMap.remove(Integer.MAX_VALUE));

    for (Integer key = min; key <= max; key += 5) {
      final Integer deleted = treeMap.remove(key);
      Assert.assertEquals(key, deleted);
    }

    for (int key = min; key <= max; ++key) {
      final boolean hasKey = treeMap.contains(key);

      if (key % 5 == 0) {
        Assert.assertFalse(hasKey);
      } else {
        Assert.assertTrue(hasKey);
      }
    }
  }

  @Test
  public void testRemoveRoot() {
    final int min = -10;
    final int max = 10;

    final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    // Inserting from min to max.
    for (int key = min; key < max; ++key) {
      treeMap.put(key, key);
    }

    for (Integer key = min; key < max; ++key) {
      final int size = treeMap.size();
      final Integer value = treeMap.remove(key);
      Assert.assertEquals(key, value);
      Assert.assertEquals(size - 1, treeMap.size());
    }

    Assert.assertTrue(treeMap.isEmpty());

    // Inserting from max to min.
    for (int key = max; key < min; --key) {
      treeMap.put(key, key);
    }

    for (Integer key = max; key < min; --key) {
      final int size = treeMap.size();
      final Integer value = treeMap.remove(key);
      Assert.assertEquals(key, value);
      Assert.assertEquals(size - 1, treeMap.size());
    }

    Assert.assertTrue(treeMap.isEmpty());
  }

  // Fills the map with numbers [min, max] coming in a random order.
  public static TreeMap<Integer, Integer> newTreeMapForRange(int min, int max) {
    final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    for (int key : newShuffledSet(min, max, 13)) {
      treeMap.put(key, key);
    }

    return treeMap;
  }

  public static Collection<Integer> newShuffledSet(final int min, final int max, final int seed) {
    final int length = max - min + 1;
    final List<Integer> result = new ArrayList<>(length);

    for (int key = min; key <= max; ++key) {
      result.add(key);
    }

    Collections.shuffle(result, new Random(seed));
    return result;
  }

}
