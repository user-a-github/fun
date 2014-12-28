package org.interview.algorithms.dynamicprogramming;

public class Knapsack {
    public static int[] knapsack01(int weights[], int[] value, int capacity) {
        int[] solution = new int[weights.length];
        int f[][] = new int[weights.length + 1][capacity + 1];

        for (int i = 0; i <= weights.length; i++) {
            f[i][0] = 0;
        }

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    if (f[i - 1][j - weights[i - 1]] + value[i - 1] > f[i - 1][j]) {
                        f[i][j] = f[i - 1][j - weights[i - 1]] + value[i - 1];
                        solution[i - 1] = 1;
                    } else {
                        f[i][j] = f[i - 1][j];
                    }
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return solution;
    }
}
