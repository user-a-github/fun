package org.interview.algorithms.backtrack;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.interview.algorithms.backtrack.SubSets.allSubsets;
import static org.junit.Assert.assertThat;

public class SubSetsTest {

    @Test
    public void shouldGenerateEmptySubsetForEmptySet() {
        String[] input = {};
        String[] expected = new String[]{"{}"};

        List<String> actual = allSubsets(input, 0);
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllTwoElementsSubsetsForABCD() {
        String[] input = {"A", "B", "C", "D"};
        String[] expected = new String[]{
                "{AB}", "{AC}", "{AD}",
                "{BC}", "{BD}", "{CD}"
        };

        List<String> actual = allSubsets(input, 2);
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllOneElementsSubsetsForABCD() {
        String[] input = {"A", "B", "C", "D"};
        String[] expected = new String[]{
                "{A}", "{B}", "{C}", "{D}"
        };

        List<String> actual = allSubsets(input, 1);
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllThreeElementsSubsetsForABCD() {
        String[] input = {"A", "B", "C", "D"};
        String[] expected = new String[]{
                "{ABC}", "{ABD}", "{ACD}", "{BCD}"
        };

        List<String> actual = allSubsets(input, 3);
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllFourElementsSubsetsForABCD() {
        String[] input = {"A", "B", "C", "D"};
        String[] expected = new String[]{
                "{ABCD}"
        };

        List<String> actual = allSubsets(input, 4);
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllZeroElementsSubsetsForABCD() {
        String[] input = {"A", "B", "C", "D"};
        String[] expected = new String[]{
                "{}"
        };

        List<String> actual = allSubsets(input, 0);
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllSubsetsForABC() {
        String[] input = {"A", "B", "C"};

        String[] expected = new String[]{
                "{ABC}",
                "{AB}", "{AC}", "{BC}",
                "{A}", "{B}", "{C}",
                "{}"
        };

        List<String> actual = allSubsets(input);
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllSubsetsForAB() {
        String[] input = {"A", "B"};

        String[] expected = new String[]{
                "{AB}",
                "{A}", "{B}",
                "{}"
        };

        List<String> actual = allSubsets(input);
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllSubsetsForA() {
        String[] input = {"A"};

        String[] expected = new String[]{
                "{A}",
                "{}"
        };

        List<String> actual = allSubsets(input);
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test
    public void shouldGenerateAllSubsetsForEmptySet() {
        String[] input = {};

        String[] expected = new String[]{
                "{}"
        };

        List<String> actual = allSubsets(input);
        assertThat(actual, containsInAnyOrder(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullSet() {
        allSubsets(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForNullSetAndSubsetSize() {
        allSubsets(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionForSubsetSizeGreaterThenSetSize() {
        String[] input = {};

        allSubsets(input, 1);
    }

}