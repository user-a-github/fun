package org.interview.algorithms.codingtasks;

import org.junit.Test;

import static org.interview.algorithms.codingtasks.RevertStringSmart.revertStringButNotWords;
import static org.junit.Assert.assertEquals;

public class RevertStringSmartTest {

    @Test
    public void shouldRevertStringButNotWords() {
        assertEquals(" sir? do, you do How 1", revertStringButNotWords("1 How do you do, sir? "));
        assertEquals(". . . Doe John is name My ", revertStringButNotWords(" My name is John Doe . . ."));
    }

    @Test
    public void shouldRevertStringButNotWordsWithManyWhitespacesBetweenWords() {
        assertEquals(" sir?   do, you    do     How   ", revertStringButNotWords("   How     do    you do,   sir? "));
    }

    @Test
    public void shouldRevertStringsWithWhitespacesOnly() {
        assertEquals(" ", revertStringButNotWords(" "));
        assertEquals("     ", revertStringButNotWords("     "));
    }

    @Test
    public void shouldRevertEmptyString() {
        assertEquals("", revertStringButNotWords(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotRevertNull() {
        assertEquals(null, revertStringButNotWords(null));
    }
}