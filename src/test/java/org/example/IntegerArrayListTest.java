package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerArrayListTest {

    @Test
    public void testAdd() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    public void testGrow() {
        IntegerArrayList list = new IntegerArrayList();
        for (int i = 0; i < 15; i++) {
            list.add(i);
        }

        assertEquals(15, list.size());
    }

    @Test
    public void testSort() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(30);
        list.add(10);
        list.add(20);
        list.sort();

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    public void testIndexOutOfBounds() {
        IntegerArrayList list = new IntegerArrayList();
        list.add(10);
        list.add(20);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
    }
}
