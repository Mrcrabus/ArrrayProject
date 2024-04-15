package org.example;

public class QuickSort<T extends Comparable<T>> {
    /**
     * Sorts the list using a quicksort algorithm.
     *
     * @param list list
     */
    public OtherArrayList<T> sort(OtherArrayList<T> list) {
        if (list.size() <= 1) {
            return list;
        }

        T pivot = list.get(0);
        OtherArrayList<T> smaller = new MyArrayList<>();
        OtherArrayList<T> greater = new MyArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            T element = list.get(i);
            if (element.compareTo(pivot) < 0)
                smaller.add(element);
            else
                greater.add(element);
        }

        smaller = sort(smaller);
        greater = sort(greater);

        smaller.add(pivot);
        for (int i = 0; i < greater.size(); i++) {
            smaller.add(greater.get(i));
        }

        return smaller;
    }

}