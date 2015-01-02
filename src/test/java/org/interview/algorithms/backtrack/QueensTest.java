package org.interview.algorithms.backtrack;

import org.junit.Test;

import static org.interview.algorithms.backtrack.Queens.placeQueens;
import static org.junit.Assert.assertEquals;

public class QueensTest {

    @Test
    public void shouldPlaceQueensForEightSizeBoard() throws Exception {
        assertEquals(92, placeQueens(8).size());
    }

    @Test
    public void shouldPlaceQueensForFourSizeBoard() throws Exception {
        assertEquals(2, placeQueens(4).size());
    }

    @Test
    public void shouldPlaceQueensForOneSizeBoard() throws Exception {
        assertEquals(1, placeQueens(1).size());
    }

    @Test
    public void shouldPlaceQueensForTwoSizeBoard() throws Exception {
        assertEquals(0, placeQueens(2).size());
    }

    @Test
    public void shouldPlaceQueensForThreeSizeBoard() throws Exception {
        assertEquals(0, placeQueens(3).size());
    }
}