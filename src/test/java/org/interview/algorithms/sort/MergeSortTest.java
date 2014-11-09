package org.interview.algorithms.sort;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.interview.algorithms.sort.MergeSort.sort;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MergeSortTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSortNulls() {
        sort(null);
    }

    @Test
    public void shouldSortEmptyArray() {
        String[] arrayToSort = {};
        sort(arrayToSort);
        assertEquals(0, arrayToSort.length);
    }

    @Test
    public void shouldSortOneElementArray() {
        String[] arrayToSort = {"A"};
        String[] expected = {"A"};
        sort(arrayToSort);
        assertThat(asList(arrayToSort), contains(expected));
    }

    @Test
    public void shouldSortArray() {
        Integer[] arrayToSort = {1, 200, -5, 56, 23, -8, 10, 50, 0, 0};
        Integer[] expected = {-8, -5, 0, 0, 1, 10, 23, 50, 56, 200};
        sort(arrayToSort);
        assertThat(asList(arrayToSort), contains(expected));
    }

    @Test
    public void shouldSortArrayWithNulls() {
        String[] arrayToSort = {"A", "B", "ABC", null, null};
        String[] expected = {"A", "ABC", "B", null, null};
        sort(arrayToSort);
        assertThat(asList(arrayToSort), contains(expected));
    }
}