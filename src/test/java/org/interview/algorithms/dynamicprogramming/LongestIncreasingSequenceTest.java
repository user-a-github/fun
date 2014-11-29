package org.interview.algorithms.dynamicprogramming;

import org.junit.Test;

import static org.interview.algorithms.dynamicprogramming.LongestIncreasingSequence.lis;
import static org.junit.Assert.assertArrayEquals;

public class LongestIncreasingSequenceTest {

    @Test
    public void shouldReturnLIS() {
        int[] sequence = {-20, 10, -2, 3, -7, 8, -4, -2, 5};
        int[] expected = {10, -2, 3, -7, 8};

        assertArrayEquals(lis(sequence), expected);
    }

    @Test
    public void shouldReturnLISForSequenceBeginsWithZero() {
        int[] sequence = {0, 10, 8, -3, 0, 2, -7, 3, 2};
        int[] expected = {0, 10, 8};

        assertArrayEquals(lis(sequence), expected);
    }

    @Test
    public void shouldReturnLISForSequenceBeginsWithZeros() {
        int[] sequence = {0, 0, 0, 0, 2, -1};
        int[] expected = {0, 0, 0, 0, 2};

        assertArrayEquals(lis(sequence), expected);
    }

    @Test
    public void shouldReturnLISForSequenceBeginsWithZeros2() {
        int[] sequence = {0, 0, 0, 0, -1};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(lis(sequence), expected);
    }

    @Test
    public void shouldReturnLISForZeroOnlySequence() {
        int[] sequence = {0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(lis(sequence), expected);
    }

    @Test
    public void shouldReturnEmptyArrayForEmptySequence() {
        int[] sequence = {};
        int[] expected = {};

        assertArrayEquals(lis(sequence), expected);
    }
}