package org.interview.algorithms.codingtasks;

public class RevertStringSmart {

    public static String revertStringButNotWords(String s) {
        if (s == null) throw new IllegalArgumentException("Can't revert nulls.");
        char[] chars = s.toCharArray();
        revertChars(chars, 0, chars.length - 1);
        for (int i = 0, prev = 0; i <= chars.length; i++) {
            if (i == chars.length || chars[i] == ' ') {
                revertChars(chars, prev, i - 1);
                prev = i + 1;
            }
        }

        return new String(chars);
    }

    private static void revertChars(char[] chars, int from, int to) {
        for (int i = from, j = to; i < j; i++, j--) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }
    }
}