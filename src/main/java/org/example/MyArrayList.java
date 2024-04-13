package org.example;

import java.util.*;

public class MyArrayList<T> implements OtherArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    public T[] list;
    private int size;

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int size) {
        list = (T[]) new Object[size];
        this.size = size;
    }

    public MyArrayList(Collection<T> c) {
        list = (T[]) new Object[c.size()];
        int i = 0;
        for(T item: c) {
            list[i++] = item;
        }

        size = c.size();
    }

    @Override
    public boolean add(T element) {
        size++;
        for (int i = 0; i < size; i++) {
            if (list[i] == null) {
                list[i] = element;
                removeNulls();
                return true;
            }
        }
        list[size++] = element;
        removeNulls();
        return true;
    }

    @Override
    public boolean add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == size) {
            add(item);
            return true;
        }
        size++;

        var temp = Arrays.copyOf(list, size);

        for (int i = size - 1; i >= 0; i--) {
            if (list[i] == null) {
                continue;
            }
            temp[i + 1] = list[i];
            if (i == index) {
                temp[i] = item;
                break;
            }
        }
        list = temp;
        removeNulls();

        return true;
    }


    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return list[index];
    }

    /**
     * @param index
     */
    @Override
    public T remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        T removedItem = list[index];

        OtherArrayList<T> newList = new MyArrayList<T>();

        for (int i = 0; i < size(); i++) {
            if (i == index) {
                continue;
            }
            newList.add(list[i]);
        }

        for (int i = 0; i < newList.size(); i++) {
            list[i] = newList.get(i);
        }

        size--;

        return removedItem;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(list, null);
        size = 0;
    }


    @Override
    public void sort(Comparator<T> comparator) {
        Arrays.sort(list, comparator);
    }


    @Override
    public void sort() {
        Arrays.sort(list, 0, size);
    }



    @Override
    public List<T> toList() {
        return new ArrayList<>(Arrays.asList(list).subList(0, size));
    }

    @Override
    public void quickSort() {
        quickSortHelper(0, size - 1);
    }

    private void quickSortHelper(int low, int high) {
        if (low < high) {
            int partitionIndex = partition(low, high);
            quickSortHelper(low, partitionIndex - 1);
            quickSortHelper(partitionIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        T pivot = list[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(list[j], pivot) < 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private int compare(T a, T b) {
        if (a.equals(b)) {
            return 0;
        } else if (a instanceof Comparable && b instanceof Comparable) {
            Comparable<T> comparableA = (Comparable<T>) a;
            return comparableA.compareTo(b);
        } else {

            return 0;
        }
    }

    private void swap(int i, int j) {
        T temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void removeNulls() {
        int length = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] != null) {
                length++;
            }
        }
        if (length < size) {
            Object[] newArray = new Object[length];
            int newIndex = 0;
            for (int i = 0; i < size; i++) {
                if (list[i] != null) {
                    newArray[newIndex++] = list[i];
                }
            }
            list = (T[]) newArray;
            size = length;
        }
    }



}
