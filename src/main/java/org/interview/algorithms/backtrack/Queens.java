package org.interview.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Queens {
    public static List<String> placeQueens(int boardSize) {
        List<String> queenPlaces = new ArrayList<>();
        int[] queens = new int[boardSize];
        placeQueens(queens, 0, queenPlaces);
        return queenPlaces;
    }

    private static void placeQueens(int[] queens, int position, List<String> queenPlaces) {
        if (queens.length == position) {
            queenPlaces.add("one more solution");
        } else {
            for (int i = 0; i < queens.length; i++) {
                queens[position] = i;
                if (isValidSquare(queens, position)) placeQueens(queens, position + 1, queenPlaces);
            }
        }
    }

    private static boolean isValidSquare(int[] queens, int square) {
        for (int i = 0; i < square; i++) {
            if (queens[i] == queens[square]) return false;
            if (queens[i] - queens[square] == square - i) return false;
            if (queens[square] - queens[i] == square - i) return false;
        }
        return true;
    }
}
