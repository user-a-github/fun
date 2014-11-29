package org.interview.algorithms.dynamicprogramming;

import static java.lang.System.arraycopy;

public class LongestIncreasingSequence {

    public static int[] lis(int[] sequence) {
        if (sequence == null) throw new IllegalArgumentException("Sequence can't be null");
        if (sequence.length == 0) {
            return new int[0];
        } else {
            int[][] function = new int[2][sequence.length];
            int[][] sequenceLength = new int[2][sequence.length];

            int i = sequence.length - 1;
            function[0][i] = sequence[i];
            function[1][i] = 0;
            sequenceLength[0][i] = 1;
            sequenceLength[1][i] = 0;
            int iPos = 0;
            while (--i >= 0) {
                if (0 > function[0][i + 1]) {
                    function[0][i] = sequence[i];
                    sequenceLength[0][i] = 1;
                } else {
                    function[0][i] = sequence[i] + function[0][i + 1];
                    sequenceLength[0][i] = sequenceLength[0][i + 1] + 1;
                }
                if (function[0][i + 1] > function[1][i + 1]) {
                    function[1][i] = function[0][i + 1];
                    sequenceLength[1][i] = sequenceLength[0][i + 1];
                    iPos = i + 1;
                } else {
                    function[1][i] = function[1][i + 1];
                    sequenceLength[1][i] = sequenceLength[1][i + 1];
                }
            }

            int[] subSequence;
            if (function[0][0] >= function[1][0]) {
                subSequence = new int[sequenceLength[0][0]];
                arraycopy(sequence, 0, subSequence, 0, subSequence.length);
            } else {
                subSequence = new int[sequenceLength[1][0]];
                arraycopy(sequence, iPos, subSequence, 0, subSequence.length);
            }
            return subSequence;
        }
    }
}
