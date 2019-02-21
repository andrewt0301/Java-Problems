
package ru.andrewt;

import org.junit.Test;

public class ArrayDequeTest {

    @Test
    public void testIsEmpty() {
        ArrayDeque<Integer> d = new ArrayDeque<>(19);


        d.addFirst(17);
        d.addFirst(18);
        for (int i = 0; i < 10; ++i) {
            d.addLast(i);
        }
        System.out.println(d.toString());

    }

}
