package org.interview.algorithms.sort;

import static org.interview.utils.Math.ge;

public class MergeSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array == null) throw new IllegalArgumentException("Can't sort null.");
        if (array.length > 1) {
            sort(array, 0, array.length - 1, new Object[array.length]);
        }
    }

    private static <T extends Comparable<T>> void sort(T[] array, int from, int to, Object[] cache) {
        if (from < to) {
            int middle = from + (to - from) / 2;
            sort(array, from, middle, cache);
            sort(array, middle + 1, to, cache);
            merge(array, from, middle, to, cache);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, int from, int middle, int to, Object[] cache) {
        for (int k = from; k <= to; k++) {
            cache[k] = array[k];
        }
        int i = from;
        int j = middle + 1;
        int c = i;
        while (i <= middle && j <= to) {
            if (ge((T) cache[i], (T) cache[j])) {
                array[c++] = (T) cache[j++];
            } else {
                array[c++] = (T) cache[i++];
            }
        }

        if (i > middle) {
            while (j <= to)
                array[c++] = (T) cache[j++];
        }
        if (j > to) {
            while (i <= middle)
                array[c++] = (T) cache[i++];
        }
    }
}
