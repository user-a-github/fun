package org.interview.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DoublyLinkedListTest {

    private static final Integer[] ONE_TWO_THREE_FOUR_FIVE = new Integer[]{1, 2, 3, 4, 5};
    private static final Integer[] ONE_TWO = new Integer[]{1, 2};
    private static final Integer[] ONE = new Integer[]{1};
    private static final Integer[] FIVE_FOUR_THREE_TWO_ONE = new Integer[]{5, 4, 3, 2, 1};
    private static final Integer[] TWO_ONE = new Integer[]{2, 1};

    private DoublyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new DoublyLinkedList<Integer>();
    }

    @Test
    public void shouldReturnEmptyListIfNoItemAdded() {
        assertTrue(list.toCollectionFromHead().isEmpty());
        assertTrue(list.toCollectionFromTail().isEmpty());
    }

    @Test
    public void shouldAddOneItemToList() {
        list.add(1);
        assertThatItemsAdded(ONE, ONE);
    }

    @Test
    public void shouldAddTwoItemsToList() {
        addOneTwo();
        assertThatItemsAdded(ONE_TWO, TWO_ONE);
    }

    @Test
    public void shouldAddItemsToList() {
        addOneTwoThreeFourFive();
        assertThatItemsAdded(ONE_TWO_THREE_FOUR_FIVE, FIVE_FOUR_THREE_TWO_ONE);
    }

    @Test
    public void shouldReverseOneItemListWithRecursion() {
        list.add(1);
        list.reverse();
        assertThatItemsAdded(ONE, ONE);
    }

    @Test
    public void shouldReverseTwoItemsWithRecursionList() {
        addOneTwo();
        list.reverse();
        assertThatItemsAdded(TWO_ONE, ONE_TWO);
    }

    @Test
    public void shouldReverseListWithRecursion() {
        addOneTwoThreeFourFive();
        list.reverse();
        assertThatItemsAdded(FIVE_FOUR_THREE_TWO_ONE, ONE_TWO_THREE_FOUR_FIVE);
    }

    @Test
    public void shouldReverseEmptyList() {
        list.reverse();
        assertTrue(list.toCollectionFromHead().isEmpty());
        assertTrue(list.toCollectionFromTail().isEmpty());
    }

    private void addOneTwo() {
        list.add(1);
        list.add(2);
    }

    private void addOneTwoThreeFourFive() {
        addOneTwo();
        list.add(3);
        list.add(4);
        list.add(5);
    }

    private void assertThatItemsAdded(Integer[] fromHead, Integer[] fromTail) {
        assertThat(list.toCollectionFromHead(), contains(fromHead));
        assertThat(list.toCollectionFromTail(), contains(fromTail));
    }
}