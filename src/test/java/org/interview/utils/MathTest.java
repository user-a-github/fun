package org.interview.utils;

import org.junit.Test;

import static org.interview.utils.Math.ge;
import static org.interview.utils.Math.gt;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MathTest {

    @Test
    public void shouldCompareObjectsForGT() {
        assertTrue(gt("a", "A"));
        assertFalse(gt("A", "A"));
    }

    @Test
    public void shouldCompareObjectsForGE() {
        assertTrue(ge("a", "A"));
        assertTrue(ge("A", "A"));
        assertFalse(ge("A", "B"));
    }

    @Test
    public void shouldCompareNulls() {
        assertTrue(gt(null, null));
        assertTrue(ge(null, null));
    }

    @Test
    public void shouldCompareObjectsAndNullsForGT() {
        assertFalse(gt(null, "a"));
        assertFalse(gt("a", null));
    }

    @Test
    public void shouldCompareObjectsAndNullsForGE() {
        assertFalse(ge(null, "a"));
        assertFalse(ge("a", null));
    }
}