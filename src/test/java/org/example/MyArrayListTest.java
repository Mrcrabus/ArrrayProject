package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    public void testAddAndGet() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    public void testAddWithIndex() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("C");
        list.add(1, "B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    public void testRemove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    public void testSize() {
        MyArrayList<String> list = new MyArrayList<>();
        assertEquals(0, list.size());

        list.add("A");
        list.add("B");
        assertEquals(2, list.size());
    }

    @Test
    public void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>(Arrays.asList(3, 1, 2));
        list.sort(Collections.<Integer>reverseOrder());

        assertEquals(Arrays.asList(3, 2, 1), list.toList());
    }

    @Test
    public void testClear() {
        OtherArrayList<String> list = new MyArrayList<>(Arrays.asList("A", "B", "C"));
        list.clear();

        assertEquals(0, list.size());
        assertNull(list.get(0));
    }

    @Test
    void quickSort() {
        MyArrayList<Integer> list = new MyArrayList<>(Arrays.asList(3, 1, 2));
        list.quickSort();

        List<Integer> expected = Arrays.asList(1, 2, 3);

        assertEquals(expected, list.toList());
    }

}