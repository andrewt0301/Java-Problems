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
        final Integer[] sortedKeys = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        final Consumer<TreeMap<Integer, Integer>> checker = treeMap -> {
            Assert.assertFalse(treeMap.isEmpty());
            Assert.assertEquals(sortedKeys.length, treeMap.size());
            Assert.assertArrayEquals(sortedKeys, treeMap.getKeys());
        };

        // Keys are put in the descending order.
        final TreeMap<Integer, Integer> treeMap1 = new TreeMap<>();
        for (int index = 9; index >= 0; --index) {
            treeMap1.put(index, 2 * index);
        }
        checker.accept(treeMap1);

        // Keys are put in the ascending order.
        final TreeMap<Integer, Integer> treeMap2 = new TreeMap<>();
        for (int index = 0; index < 10; ++index) {
            treeMap2.put(index, 2 * index);
        }
        checker.accept(treeMap2);

        // Half of keys is put in the ascending order and
        // another half is put in the descending order.
        final TreeMap<Integer, Integer> treeMap3 = new TreeMap<>();
        for (int index = 0; index < 5; ++index) {
            treeMap3.put(index, 2 * index);
        }
        for (int index = 9; index >= 5; --index) {
            treeMap3.put(index, 2 * index);
        }
        checker.accept(treeMap3);
    }

    @Test
    public void test() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(0, 0);
        treeMap.put(-1, 1);
        treeMap.put(3, 3);
        treeMap.put(2, 2);

        System.out.println("--------------------------------------");
        System.out.println(treeMap);

        treeMap.remove(1);

        System.out.println("--------------------------------------");
        System.out.println(treeMap);

        System.out.println("--------------------------------------");
        System.out.println(Arrays.asList(treeMap.getKeys()));

    }
}
