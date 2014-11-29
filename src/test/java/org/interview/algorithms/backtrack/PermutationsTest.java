package org.interview.algorithms.backtrack;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.interview.algorithms.backtrack.Permutations.getAllPermutations;
import static org.junit.Assert.assertThat;

public class PermutationsTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegative() {
        getAllPermutations(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForZero() {
        getAllPermutations(0);
    }

    @Test
    public void shouldGenerateAllPermutationsForOne() {
        List<String> actual = getAllPermutations(1);

        String[] expected = new String[]{
                asList(new Integer[]{1}).toString(),
        };

        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllPermutationsForOneAndTwo() {
        List<String> actual = getAllPermutations(2);

        String[] expected = new String[]{
                asList(new Integer[]{1, 2}).toString(),
                asList(new Integer[]{2, 1}).toString()
        };

        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllPermutationsForOneAndTwoAndThree() {
        List<String> actual = getAllPermutations(3);

        String[] expected = new String[]{
                asList(new Integer[]{1, 2, 3}).toString(),
                asList(new Integer[]{1, 3, 2}).toString(),
                asList(new Integer[]{2, 3, 1}).toString(),
                asList(new Integer[]{2, 1, 3}).toString(),
                asList(new Integer[]{3, 1, 2}).toString(),
                asList(new Integer[]{3, 2, 1}).toString()
        };

        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllPermutationsForOneAndTwoThreeAndFour() {
        List<String> actual = getAllPermutations(4);

        String[] expected = new String[]{
                asList(new Integer[]{1, 2, 3, 4}).toString(),
                asList(new Integer[]{1, 2, 4, 3}).toString(),
                asList(new Integer[]{1, 3, 4, 2}).toString(),
                asList(new Integer[]{1, 3, 2, 4}).toString(),
                asList(new Integer[]{1, 4, 2, 3}).toString(),
                asList(new Integer[]{1, 4, 3, 2}).toString(),

                asList(new Integer[]{2, 1, 3, 4}).toString(),
                asList(new Integer[]{2, 1, 4, 3}).toString(),
                asList(new Integer[]{2, 3, 4, 1}).toString(),
                asList(new Integer[]{2, 3, 1, 4}).toString(),
                asList(new Integer[]{2, 4, 1, 3}).toString(),
                asList(new Integer[]{2, 4, 3, 1}).toString(),

                asList(new Integer[]{3, 1, 2, 4}).toString(),
                asList(new Integer[]{3, 1, 4, 2}).toString(),
                asList(new Integer[]{3, 2, 4, 1}).toString(),
                asList(new Integer[]{3, 2, 1, 4}).toString(),
                asList(new Integer[]{3, 4, 1, 2}).toString(),
                asList(new Integer[]{3, 4, 2, 1}).toString(),

                asList(new Integer[]{4, 1, 2, 3}).toString(),
                asList(new Integer[]{4, 1, 3, 2}).toString(),
                asList(new Integer[]{4, 2, 3, 1}).toString(),
                asList(new Integer[]{4, 2, 1, 3}).toString(),
                asList(new Integer[]{4, 3, 1, 2}).toString(),
                asList(new Integer[]{4, 3, 2, 1}).toString(),
        };

        assertThat(actual, containsInAnyOrder(expected));
    }
}