package org.example;

public class QuickSort<T extends Comparable<T>> {

    public OtherArrayList<T> quickSort(OtherArrayList<T> list) {
        if (list.size() == 0){
            return list;
        }
        OtherArrayList<T> sorted;  // this shall be the sorted list to return, no needd to initialise
        OtherArrayList<T> smaller = new MyArrayList<>() {
        }; // Vehicles smaller than pivot
        OtherArrayList<T> greater = new MyArrayList<>(); // Vehicles greater than pivot
        T pivot = list.get(0);  // first Vehicle in list, used as pivot

        T j;     // Variable used for Vehicles in the loop
        for (int i = 1; i < list.size(); i++) {
            j = list.get(i);
            if (j.compareTo(pivot) < 0)   // make sure Vehicle has proper compareTo method
                smaller.add(j);
            else
                greater.add(j);
        }
        smaller = quickSort(smaller);  // capitalise 's'
        greater = quickSort(greater);  // sort both halfs recursively
        smaller.add(pivot);          // add initial pivot to the end of the (now sorted) smaller Vehicles

        for (int i = 0; i < greater.size(); i++) {
            smaller.add(greater.get(i));
        }
//        smaller.addAll(greater);     // add the (now sorted) greater Vehicles to the smaller ones (now smaller is essentially your sorted list)
        sorted = smaller;            // assign it to sorted; one could just as well do: return smaller

        return sorted;
    }

}