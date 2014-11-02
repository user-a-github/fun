package org.interview.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LinkedListTest {

    private static final String[] CDCBA_EXPECTED = new String[]{"C", "D", "C", "B", "A"};
    private static final String[] ABCDC_EXPECTED = new String[]{"A", "B", "C", "D", "C"};
    private LinkedList<String> list;

    @Before
    public void doSetup() {
        list = new LinkedList<String>();
    }

    @Test
    public void shouldAddElements() {
        assertTrue(list.asCollection().isEmpty());

        addABCDCValues();
        assertThat(list.asCollection(), contains(ABCDC_EXPECTED));
    }

    @Test
    public void shouldReverseEmptyListRecursively() {
        list.reverseWithRecursion();
        assertTrue(list.asCollection().isEmpty());
    }

    @Test
    public void shouldReverseOneElementListRecursively() {
        list.add("A");
        list.reverseWithRecursion();
        assertThat(list.asCollection(), contains("A"));
    }

    @Test
    public void shouldReverseListRecursively() {
        addABCDCValues();
        list.reverseWithRecursion();
        assertThat(list.asCollection(), contains(CDCBA_EXPECTED));
    }

    @Test
    public void shouldReverseListIteratively() {
        addABCDCValues();
        list.reverseWithIteration();
        assertThat(list.asCollection(), contains(CDCBA_EXPECTED));
    }

    @Test
    public void shouldReverseEmptyIteratively() {
        list.reverseWithIteration();
        assertTrue(list.asCollection().isEmpty());
    }

    @Test
    public void shouldReverseOneElementListIteratively() {
        list.add("A");
        list.reverseWithIteration();
        assertThat(list.asCollection(), contains("A"));
    }

    private void addABCDCValues() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("C");
    }
}