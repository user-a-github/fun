package org.interview.algorithms.sort;

import static org.interview.utils.Math.gt;
import static org.interview.utils.Swap.swap;

public class QuickSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null) throw new IllegalArgumentException("Can't sort null.");
        if (array.length > 0) {
            sort(array, 0, array.length - 1);
        }
    }

    private static <T extends Comparable<T>> void sort(T[] array, int from, int to) {
        if (to - from > 0) {
            int p = pivot(array, from, to);
            sort(array, from, p - 1);
            sort(array, p + 1, to);
        }
    }

    private static <T extends Comparable<T>> int pivot(T[] array, int from, int to) {
        int p = from;
        T t = array[p];
        if (t == null) throw new IllegalArgumentException("Can't sort nulls");
        for (int i = from; i <= to; i++) {
            if (gt(t, array[i])) {
                swap(array, i, ++p);
            }
        }
        swap(array, from, p);
        return p;
    }
}