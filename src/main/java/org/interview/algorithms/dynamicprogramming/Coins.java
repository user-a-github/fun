package org.interview.algorithms.dynamicprogramming;

import static java.lang.Integer.MAX_VALUE;

public class Coins {
    public static int[] COINS = {1, 3, 5, 10};

    public static int allCombinationsToReturnChange(int change) {
        if (change < 0) throw new IllegalArgumentException("Change can't be negative.");
        int[] function = new int[change + 1];
        function[0] = 1;
        for (int i = 1; i < function.length; i++) {
            int n = 0;
            for (int j = 0; j < COINS.length; j++) {
                if (i >= COINS[j])
                    n += function[i - COINS[j]];
            }
            function[i] = n;
        }

        return function[change];
    }

    public static int minimumCoinsToReturnChange(int change) {
        if (change < 0) throw new IllegalArgumentException("Change can't be negative.");
        int[] function = new int[change + 1];
        function[0] = 0;
        for (int i = 1; i < function.length; i++) {
            int min = MAX_VALUE;
            for (int j = 0; j < COINS.length; j++) {
                if (i >= COINS[j] && min > function[i - COINS[j]])
                    min = function[i - COINS[j]];
            }
            function[i] = min + 1;
        }
        return function[change];
    }
}
