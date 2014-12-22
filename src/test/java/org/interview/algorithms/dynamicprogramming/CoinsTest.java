package org.interview.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.interview.algorithms.dynamicprogramming.Coins.allCombinationsToReturnChange;
import static org.interview.algorithms.dynamicprogramming.Coins.minimumCoinsToReturnChange;
import static org.junit.Assert.assertEquals;

public class CoinsTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegativeChange() {
        allCombinationsToReturnChange(-1);
        minimumCoinsToReturnChange(-1);
    }

    @Test
    public void shouldReturnNumberForZeroChange() {
        assertEquals(1, allCombinationsToReturnChange(0));
    }

    @Test
    public void shouldReturnNumberForChangeLessMaximumCoin() {
        assertEquals(8, allCombinationsToReturnChange(6));
    }

    @Test
    public void shouldReturnNumberForChangeMaximumCoin() {
        assertEquals(76, allCombinationsToReturnChange(11));
    }

    @Test
    public void shouldReturnMinimumNumberForZeroChange() {
        assertEquals(0, minimumCoinsToReturnChange(0));
    }

    @Test
    public void shouldReturnMinimumNumberForChangeLessThenMaximumCoin() {
        assertEquals(3, minimumCoinsToReturnChange(7));
        assertEquals(2, minimumCoinsToReturnChange(8));
    }

    @Test
    public void shouldReturnMinimumNumberForChange() {
        assertEquals(2, minimumCoinsToReturnChange(11));
    }

}