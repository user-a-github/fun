package org.interview.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.interview.algorithms.dynamicprogramming.Coins.allCombinationsToReturnChange;
import static org.junit.Assert.assertEquals;

public class CoinsTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegativeChange() {
        allCombinationsToReturnChange(-1);
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
    public void shouldReturnNumberForChangeGrateMaximumCoin() {
        assertEquals(76, allCombinationsToReturnChange(11));
    }

}