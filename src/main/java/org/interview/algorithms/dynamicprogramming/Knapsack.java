package org.interview.algorithms.dynamicprogramming;

import static java.lang.Integer.MIN_VALUE;
import static java.lang.Math.max;

public class Knapsack {
    public static boolean[] knapsack01(int weights[], int[] values, int capacity) {

        validateInput(weights, values, capacity);

        int f[][] = new int[weights.length + 1][capacity + 1];
        boolean[][] sol = new boolean[weights.length + 1][capacity + 1];

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                int v = (weights[i - 1] <= j) ? f[i - 1][j - weights[i - 1]] + values[i - 1] : MIN_VALUE;
                f[i][j] = max(f[i - 1][j], v);
                sol[i][j] = v > f[i - 1][j];
            }
        }

        return buildSolution(weights, capacity, sol);
    }

    private static boolean[] buildSolution(int[] weights, int capacity, boolean[][] sol) {
        boolean[] solution = new boolean[weights.length];
        for (int n = weights.length, w = capacity; n > 0; n--) {
            if (sol[n][w]) {
                solution[n - 1] = true;
                w = w - weights[n - 1];
            } else {
                solution[n - 1] = false;
            }
        }
        return solution;
    }

    private static void validateInput(int[] weights, int[] values, int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Knapsack capacity is negative.");
        if (weights == null) throw new IllegalArgumentException("Weights array can't be null.");
        if (values == null) throw new IllegalArgumentException("Values array can't be null.");
        if (weights.length != values.length)
            throw new IllegalArgumentException("Weights and values arrays should have the same length.");
    }
}
