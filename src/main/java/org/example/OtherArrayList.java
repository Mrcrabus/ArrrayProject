package org.example;

import java.util.Comparator;

public interface OtherArrayList<T> {
    /**
     * Method to push an element to the end of the list.
     *
     * @param item The element to add to the end of the list.
     * @return true if the element was successfully added.
     */
    boolean add(T item);

    /**
     * Inserts the element at the position in the list.
     *
     * @param index The index at which the element is to be inserted.
     * @param item  The element to be inserted.
     * @return true if the element was successfully added at the specified position.
     */
    boolean add(int index, T item);

    /**
     * Retrieves the element at the position in the list.
     *
     * @param index The index of the element to return.
     * @return The element at the position in the list.
     */
    T get(int index);

    /**
     * Removes the element at the position in the list.
     *
     * @param index The index of the element to be removed.
     * @return The element that was removed from the list.
     */
    T remove(int index);

    /**
     * Returns the number of elements in the list.
     *
     * @return The number of elements in the list.
     */
    int size();

    /**
     * Removes all elements from the list.
     */
    void clear();

    /**
     * Sorts the list according to the order induced by the specified comparator.
     *
     * @param comparator The comparator to determine the order of the list.
     */
    void sort(Comparator<T> comparator);

    /**
     * Sorts the list into ascending order.
     */
    void sort();

    /**
     * Sorts the list using a quicksort algorithm.
     */
    void quickSort();

    /**
     * Converts the list to another type of list.
     *
     * @param <T> The type of the new list.
     * @return The converted list.
     */
    <T> T toList();

}
