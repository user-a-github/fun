package org.interview.utils;

public final class Math {
    public static <T extends Comparable<T>> boolean gt(T a, T b) {
        return a == null ? a == b : (b == null ? false : a.compareTo(b) > 0);
    }
}
