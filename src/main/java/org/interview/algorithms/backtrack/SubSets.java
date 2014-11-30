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

    private static <T> void allSubsets(int i, T[] a, boolean[] b, List<String> allSubsets) {
        if (i == a.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int j = 0; j < a.length; j++) {
                if (b[j]) {
                    sb.append(a[j]);
                }
            }
            sb.append("}");
            allSubsets.add(sb.toString());
        } else {
            for (int k = 0; k < 2; k++) {
                b[i] = k == 0;
                allSubsets(i + 1, a, b, allSubsets);
                b[i] = k != 0;
            }
        }
    }
}
