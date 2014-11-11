package org.interview.algorithms.sort;

import org.interview.datastructures.heap.Heap;

import static org.interview.utils.Swap.swap;

public class HeapSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null) throw new IllegalArgumentException("Can't sort null.");
        if (array.length > 1) {
            Heap<T> heap = new Heap<T>(array);
            heap.heapify();
            for (int i = 0; i < array.length; i++) {
                array[heap.getCapacity() - 1] = heap.min();
            }
            int k = 0;
            int j = array.length - 1;
            while (k < j) {
                swap(array, k++, j--);
            }
        }
    }
}
