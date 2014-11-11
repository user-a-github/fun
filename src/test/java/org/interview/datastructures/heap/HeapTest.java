package org.interview.datastructures.heap;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HeapTest {

    private Heap<String> heap;
    private final String[] STRINGS_INPUT = {"B", "D", "A", "AB", "P", "W", "A"};
    private final String[] STRINGS_EXPECTED = {"A", "AB", "A", "D", "P", "W", "B"};
    private final String[] STRINGS_INPUT_WITH_NULL = {null, "D", "A", "AB", null, "a", "A"};
    private final String[] AFTER_MIN_EXPECTED = {"A", "AB", "B", "D", "P", "W", null};
    private final String[] AFTER_ALL_MIN_EXPECTED = {null, null, null, null, null, null, null};
    private final String[] ONE_STRING_INPUT = {"B"};
    private final String[] ONE_STRINGS_EXPECTED = {"B"};
    private final String[] EMPTY = {};

    @Test
    public void shouldReturnMinElementFromHeap() {
        heap = new Heap<String>(STRINGS_INPUT);
        heap.heapify();
        String actual = heap.min();
        assertEquals(actual, "A");
        assertThat(asList(heap.heap), contains(AFTER_MIN_EXPECTED));
    }

    @Test
    public void shouldReturnMinElementFromOneElementHeap() {
        heap = new Heap<String>(ONE_STRING_INPUT);
        heap.heapify();
        String actual = heap.min();
        assertEquals(actual, "B");
        assertThat(asList(heap.heap), contains(ONE_STRING_INPUT));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfAllElementsReturnedFromHeap() {
        heap = new Heap<String>(STRINGS_INPUT);
        heap.heapify();
        for (int i = 0; i < STRINGS_INPUT.length; i++)
            heap.min();

        assertThat(asList(heap.heap), contains(AFTER_ALL_MIN_EXPECTED));

        heap.min();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForEmptyHeapMinOperation() {
        heap = new Heap<String>(EMPTY);
        heap.min();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArrayContainsNulls() {
        heap = new Heap<String>(STRINGS_INPUT_WITH_NULL);
        heap.heapify();
    }

    @Test
    public void shouldBuildHeap() {
        heap = new Heap<String>(STRINGS_INPUT);
        heap.heapify();
        assertThat(asList(heap.heap), contains(STRINGS_EXPECTED));
    }

    @Test
    public void shouldBuildHeapFromEmptyArray() {
        heap = new Heap<String>(EMPTY);
        heap.heapify();
        assertEquals(0, heap.heap.length);
    }

    @Test
    public void shouldBuildHeapFromOneElementArray() {
        heap = new Heap<String>(ONE_STRING_INPUT);
        heap.heapify();
        assertThat(asList(heap.heap), contains(ONE_STRINGS_EXPECTED));
    }
}