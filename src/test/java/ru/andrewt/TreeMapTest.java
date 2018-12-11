/**
 * @file TreeMapTest
 * @author Tatarnikov_A
 * @date 23.10.2018
 * @short
 */

package ru.andrewt;

import org.junit.Test;

import java.util.Arrays;

public class TreeMapTest {

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
