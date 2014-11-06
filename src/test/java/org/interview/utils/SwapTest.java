package org.interview.utils;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.interview.utils.Swap.swap;
import static org.junit.Assert.assertThat;

public class SwapTest {

    @Test
    public void shouldSwapTwoElementsInArray1() {
        Integer[] actualArray = {1, 2, 3};
        Integer[] expectedArray = {1, 3, 2};
        swap(actualArray, 1, 2);
        assertThat(asList(actualArray), contains(expectedArray));
    }

    @Test
    public void shouldSwapTwoElementsInArray2() {
        Integer[] actualArray = {1, 2, 3};
        Integer[] expectedArray = {1, 2, 3};
        swap(actualArray, 2, 2);
        assertThat(asList(actualArray), contains(expectedArray));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionForOutOfBoundIndexes1() {
        Integer[] actualArray = {1, 2, 3};
        swap(actualArray, 1, 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionForOutOfBoundIndexes2() {
        Integer[] actualArray = {1, 2, 3};
        swap(actualArray, 1, 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionForOutOfBoundIndexes3() {
        Integer[] actualArray = {};
        swap(actualArray, 1, 1);
    }
}