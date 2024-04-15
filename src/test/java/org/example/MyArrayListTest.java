package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    public void testSortIntegers() {
        MyArrayList<Integer> list = new MyArrayList<>(Arrays.asList(3, 1, 2));
        list.sort(Collections.<Integer>reverseOrder());

        assertEquals(Arrays.asList(3, 2, 1), list.toList());

    }

    @Test
    public void testSortStrings() {
        MyArrayList<String> list1 = new MyArrayList<>(Arrays.asList("l", "A", "W", "1", "Lol", "Hello World"));
        List<String> list2 = new ArrayList<>(Arrays.asList("l", "A", "W", "1", "Lol", "Hello World"));
        list2.sort(Collections.<String>reverseOrder());
        list1.sort(Collections.<String>reverseOrder());

        assertEquals(list2, list1.toList());
    }
    @Test
    public void testSortChars() {
        MyArrayList<Character> list1 = new MyArrayList<>(Arrays.asList('b', 'a', 'c', 'z', 'e', 'f'));
        List<Character> list2 = new ArrayList<>(Arrays.asList('b', 'a', 'c', 'z', 'e', 'f'));
        list2.sort(Collections.<Character>reverseOrder());
        list1.sort(Collections.<Character>reverseOrder());

        assertEquals(list2, list1.toList());
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