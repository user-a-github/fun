package org.interview.algorithms.dynamicprogramming;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.interview.algorithms.dynamicprogramming.Knapsack.knapsack01;
import static org.junit.Assert.assertThat;

public class Knapsack01Test {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForDifferentLengthInputArrays() {
        int[] w = {10, 20};
        int[] v = {10, 20, 30};
        knapsack01(w, v, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegativeKnapsackCapacity() {
        int[] w = {10, 20, 30};
        int[] v = {10, 20, 30};
        knapsack01(w, v, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionNullWeightInputArray() {
        int[] v = {10, 20, 30};
        knapsack01(null, v, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionNullValuesInputArray() {
        int[] w = {10, 20, 30};
        knapsack01(w, null, 5);
    }

    @Test
    public void shouldReturnEmptyKnapsackForOverWeightItems() {
        int[] w = {10, 20, 30};
        int[] v = {10, 20, 30};
        boolean[] expected = {false, false, false};
        boolean[] actual = knapsack01(w, v, 5);
        assertThat(asList(actual), contains(expected));
    }

    @Test
    public void shouldReturnEmptyKnapsackForZeroCapacity() {
        int[] w = {10, 20, 30};
        int[] v = {10, 20, 30};
        boolean[] expected = {false, false, false};
        boolean[] actual = knapsack01(w, v, 0);
        assertThat(asList(actual), contains(expected));
    }

    @Test
    public void shouldReturnKnapsackForSimpleItems() {
        int[] w = {3, 2, 1};
        int[] v = {1, 3, 10};
        boolean[] expected = {false, true, true};
        boolean[] actual = knapsack01(w, v, 4);
        assertThat(asList(actual), contains(expected));
    }

    @Test
    public void shouldReturnEmptyKnapsackForEmptyInputArrays() {
        int[] w = {};
        int[] v = {};
        boolean[] expected = {};
        boolean[] actual = knapsack01(w, v, 5);
        assertThat(asList(actual), contains(expected));
    }

    /*
    Test set 01 from here: http://people.sc.fsu.edu/~jburkardt/datasets/knapsack_01/knapsack_01.html
     */
    @Test
    public void shouldReturnKnapsackForProblem01() {
        int[] w = {23, 31, 29, 44, 53, 38, 63, 85, 89, 82};
        int[] v = {92, 57, 49, 68, 60, 43, 67, 84, 87, 72};
        boolean[] expected = {true, true, true, true, false, true, false, false, false, false};
        boolean[] actual = knapsack01(w, v, 165);
        assertThat(asList(actual), contains(expected));
    }

    /*
    Test set 02 from here: http://people.sc.fsu.edu/~jburkardt/datasets/knapsack_01/knapsack_01.html
     */
    @Test
    public void shouldReturnKnapsackForProblem02() {
        int[] w = {12, 7, 11, 8, 9};
        int[] v = {24, 13, 23, 15, 16};
        boolean[] expected = {false, true, true, true, false};
        boolean[] actual = knapsack01(w, v, 26);
        assertThat(asList(actual), contains(expected));
    }

    /*
    Test set 08 from here: http://people.sc.fsu.edu/~jburkardt/datasets/knapsack_01/knapsack_01.html
     */
    @Test
    public void shouldReturnKnapsackForProblem08() {
        int[] w = {382745, 799601, 909247, 729069, 467902, 44328, 34610, 698150, 823460, 903959, 853665, 551830, 610856, 670702, 488960, 951111, 323046, 446298, 931161, 31385, 496951, 264724, 224916, 169684};
        int[] v = {825594, 1677009, 1676628, 1523970, 943972, 97426, 69666, 1296457, 1679693, 1902996, 1844992, 1049289, 1252836, 1319836, 953277, 2067538, 675367, 853655, 1826027, 65731, 901489, 577243, 466257, 369261};
        boolean[] expected = {true, true, false, true, true, true, false, false, false, true, true, false, true, false, false, true, false, false, false, false, false, true, true, true};
        boolean[] actual = knapsack01(w, v, 6404180);
        assertThat(asList(actual), contains(expected));
    }
}