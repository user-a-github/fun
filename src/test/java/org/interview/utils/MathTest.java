package org.interview.utils;

import org.junit.Test;

import static org.interview.utils.Math.gt;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MathTest {

    @Test
    public void shouldCompareObjects() {
        assertTrue(gt("a", "A"));
    }

    @Test
    public void shouldCompareNulls() {
        assertTrue(gt(null, null));
    }

    @Test
    public void shouldCompareObjectsAndNulls() {
        assertFalse(gt(null, "a"));
        assertFalse(gt("a", null));
    }
}