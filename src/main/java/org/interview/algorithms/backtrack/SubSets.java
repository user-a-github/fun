package org.interview.algorithms.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static <T> List<String> allSubsets(T[] a) {
        if (a == null) throw new IllegalArgumentException("Can't generate subsets for nulls");
        List<String> allSubsets = new ArrayList<>();
        boolean[] b = new boolean[a.length];
        allSubsets(0, a, b, allSubsets);
        return allSubsets;
    }

    public static <T> List<String> allSubsets(T[] a, int k) {
        if (a == null) throw new IllegalArgumentException("Can't generate subsets for nulls");
        if (a.length < k)
            throw new IllegalArgumentException("Can't generate subsets for size greater then original set length");
        List<String> allSubsets = new ArrayList<>();
        boolean[] b = new boolean[a.length];
        allSubsets(0, k, 0, a, b, allSubsets);
        return allSubsets;
    }

    private static <T> void allSubsets(int i, T[] a, boolean[] b, List<String> allSubsets) {
        if (i == a.length) {
            allSubsets.add(subsetsAsString(a, b));
        } else {
            b[i] = false;
            allSubsets(i + 1, a, b, allSubsets);

            b[i] = true;
            allSubsets(i + 1, a, b, allSubsets);
            b[i] = false;
        }
    }


    private static <T> void allSubsets(int i, int subsetLength, int currentLength, T[] a, boolean[] b, List<String> allSubsets) {
        if (i == a.length) {
            if (subsetLength == currentLength) {
                allSubsets.add(subsetsAsString(a, b).toString());
            }
        } else {
            if (currentLength <= subsetLength) {
                b[i] = false;
                allSubsets(i + 1, subsetLength, currentLength, a, b, allSubsets);
            }
            if (currentLength < subsetLength) {
                b[i] = true;
                allSubsets(i + 1, subsetLength, currentLength + 1, a, b, allSubsets);
                b[i] = false;
            }
        }
    }

    private static <T> String subsetsAsString(T[] a, boolean[] b) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int j = 0; j < a.length; j++) {
            if (b[j]) {
                sb.append(a[j]);
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
