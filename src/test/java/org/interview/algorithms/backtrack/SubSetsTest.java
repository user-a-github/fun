package org.interview.algorithms.backtrack;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.interview.algorithms.backtrack.SubSets.allSubsets;
import static org.junit.Assert.assertThat;

public class SubSetsTest {

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

}