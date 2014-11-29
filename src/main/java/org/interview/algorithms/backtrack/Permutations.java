package org.interview.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.interview.utils.Swap.swap;

public class Permutations {
    public static List<String> getAllPermutations(int n) {
        if (n <= 0) throw new IllegalArgumentException("Input parameter should be greater then zero.");
        List<String> allPermutations = new ArrayList<>();
        permutations(0, initArrayByIntegersForSize(n), allPermutations);
        return allPermutations;
    }

    private static Integer[] initArrayByIntegersForSize(int n) {
        Integer[] permutation = new Integer[n];
        for (int i = 0; i < permutation.length; i++) permutation[i] = i + 1;
        return permutation;
    }

    private static void permutations(int i, Integer[] permutation, List<String> allPermutations) {
        if (i == permutation.length) {
            allPermutations.add(asList(permutation).toString());
            return;
        } else {
            for (int j = i; j < permutation.length; j++) {
                swap(permutation, i, j);
                permutations(i + 1, permutation, allPermutations);
                swap(permutation, i, j);
            }
        }
    }
}
