package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        QuickSort<String> sorter = new QuickSort<>();

        OtherArrayList<String> input = new MyArrayList<>(2);
        input.add("S");
        input.add("12de");
        input.add("ABC");
        OtherArrayList<String> expected = new MyArrayList<>(Arrays.asList(new String[]{ "12de", "ABC", "S"}));

        OtherArrayList<String> result = sorter.sort(input);
        assertEquals(expected.toString(), result.toString());
    }

    @Test
    public void testEmptyList() {
        QuickSort<Integer> sorter = new QuickSort<>();
        OtherArrayList<Integer> list = new MyArrayList<>();

        OtherArrayList<Integer> sortedList = sorter.sort(list);

        OtherArrayList<Integer> expected = new MyArrayList<>();
        assertEquals(expected.toString(), sortedList.toString());
    }

    @Test
    public void testSingleElementList() {
        QuickSort<Integer> sorter = new QuickSort<>();
        OtherArrayList<Integer> list = new MyArrayList<>();
        list.add(1);

        OtherArrayList<Integer> sortedList = sorter.sort(list);

        OtherArrayList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        assertEquals(expected.toString(), sortedList.toString());
    }
}
