package org.interview.algorithms.dynamicprogramming;

import static java.lang.System.arraycopy;

public class LongestIncreasingSequence {

    private static class Item {
        public final int value;
        public final int subSequenceLength;

        public Item(int value, int subSequenceLength) {
            this.value = value;
            this.subSequenceLength = subSequenceLength;
        }
    }

    public static int[] lis(int[] sequence) {
        if (sequence == null) throw new IllegalArgumentException("Sequence can't be null");
        if (sequence.length == 0) {
            return new int[0];
        } else {
            Item[][] function = new Item[2][sequence.length];

            int i = sequence.length - 1;
            function[0][i] = new Item(sequence[i], 1);
            function[1][i] = new Item(0, 0);
            int iPos = 0;
            while (--i >= 0) {
                if (0 > function[0][i + 1].value) {
                    function[0][i] = new Item(sequence[i], 1);
                } else {
                    function[0][i] = new Item(sequence[i] + function[0][i + 1].value, function[0][i + 1].subSequenceLength + 1);
                }
                if (function[0][i + 1].value > function[1][i + 1].value) {
                    function[1][i] = function[0][i + 1];
                    iPos = i + 1;
                } else {
                    function[1][i] = function[1][i + 1];
                }
            }

            int[] subSequence;
            if (function[0][0].value >= function[1][0].value) {
                subSequence = new int[function[0][0].subSequenceLength];
                arraycopy(sequence, 0, subSequence, 0, subSequence.length);
            } else {
                subSequence = new int[function[1][0].subSequenceLength];
                arraycopy(sequence, iPos, subSequence, 0, subSequence.length);
            }
            return subSequence;
        }
    }
}
