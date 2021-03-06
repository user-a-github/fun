package org.interview.datastructures.tree;

import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.*;

public class BinaryTreeTest {
    /*
                                        100
                       -8                                   105
                            0                         102             306
                         -5    0                               150
                                      0
                                            50
                                        10          55
                                     3                   60
     */
    private BinaryTree<Integer> tree;
    private static final Integer[] INPUT_VALUES = {100, -8, 105, 306, 0, 0, 0, 50, -5, 55, 60, 150, 102, 10, 3};
    private static final Integer[] BREADTH_FIRST_EXPECTED = new Integer[]{100, -8, 105, 0, 102, 306, -5, 0, 150, 0, 50, 10, 55, 3, 60};
    private static final Integer[] IN_ORDER_EXPECTED = new Integer[]{-8, -5, 0, 0, 0, 3, 10, 50, 55, 60, 100, 102, 105, 150, 306};
    private static final Integer[] PRE_ORDER_EXPECTED = new Integer[]{100, -8, 0, -5, 0, 0, 50, 10, 3, 55, 60, 105, 102, 306, 150};
    private static final Integer[] POST_ORDER_EXPECTED = new Integer[]{-5, 3, 10, 60, 55, 50, 0, 0, 0, -8, 102, 150, 306, 105, 100};

    private static final Integer[] PATH_ONE = new Integer[]{100, -8, 0, -5};
    private static final Integer[] PATH_TWO = new Integer[]{100, -8, 0, 0, 0, 50, 10, 3};
    private static final Integer[] PATH_THREE = new Integer[]{100, -8, 0, 0, 0, 50, 55, 60};
    private static final Integer[] PATH_FOUR = new Integer[]{100, 105, 102};
    private static final Integer[] PATH_FIVE = new Integer[]{100, 105, 306, 150};

    @Before
    public void setUp() {
        tree = new BinaryTree<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddNulls() {
        tree.add(null);
    }

    @Test
    public void shouldAddNotNullElements() {
        addValueToTree(INPUT_VALUES);
        assertTree(tree, IN_ORDER_EXPECTED, PRE_ORDER_EXPECTED, POST_ORDER_EXPECTED);
    }

    @Test
    public void shouldTraversBreadthFirstForEmptyTree() {
        assertTrue(tree.breadthFirst().isEmpty());
    }

    @Test
    public void shouldTraversBreadthFirstForOneElementAndTwoElementsTree() {
        tree.add(10);
        assertThat(tree.breadthFirst(), contains(10));
        tree.add(0);
        assertThat(tree.breadthFirst(), contains(10, 0));
    }

    @Test
    public void shouldTraversBreadthFirst() {
        addValueToTree(INPUT_VALUES);
        assertThat(tree.breadthFirst(), contains(BREADTH_FIRST_EXPECTED));
    }

    @Test
    public void shouldTraversPreOrderForEmptyTree() {
        assertTrue(tree.preOrder().isEmpty());
        assertTrue(tree.preOrderWithIteration().isEmpty());
    }

    @Test
    public void shouldTraversPreOrderForOneElementAndTwoElementsTree() {
        tree.add(10);
        assertThat(tree.preOrder(), contains(10));
        assertThat(tree.preOrderWithIteration(), contains(10));
        tree.add(0);
        assertThat(tree.preOrder(), contains(10, 0));
        assertThat(tree.preOrderWithIteration(), contains(10, 0));
    }

    @Test
    public void shouldTraversPreOrder() {
        addValueToTree(INPUT_VALUES);
        assertThat(tree.preOrder(), contains(PRE_ORDER_EXPECTED));
        assertThat(tree.preOrderWithIteration(), contains(PRE_ORDER_EXPECTED));
    }

    @Test
    public void shouldTraversPostOrderForEmptyTree() {
        assertTrue(tree.postOrder().isEmpty());
        assertTrue(tree.postOrderWithIteration().isEmpty());
    }

    @Test
    public void shouldTraversPostOrderForOneElementAndTwoElementsTree() {
        tree.add(10);
        assertThat(tree.postOrder(), contains(10));
        assertThat(tree.postOrderWithIteration(), contains(10));
        tree.add(0);
        assertThat(tree.postOrder(), contains(0, 10));
        assertThat(tree.postOrderWithIteration(), contains(0, 10));
    }

    @Test
    public void shouldTraversPostOrder() {
        addValueToTree(INPUT_VALUES);
        assertThat(tree.postOrder(), contains(POST_ORDER_EXPECTED));
        assertThat(tree.postOrderWithIteration(), contains(POST_ORDER_EXPECTED));
    }

    @Test
    public void shouldTraversInOrderForEmptyTree() {
        assertTrue(tree.inOrder().isEmpty());
        assertTrue(tree.inOrderWithIteration().isEmpty());
    }

    @Test
    public void shouldTraversInOrderForOneElementAndTwoElementsTree() {
        tree.add(10);
        assertThat(tree.inOrder(), contains(10));
        assertThat(tree.inOrderWithIteration(), contains(10));
        tree.add(0);
        assertThat(tree.inOrder(), contains(0, 10));
        assertThat(tree.inOrderWithIteration(), contains(0, 10));
    }

    @Test
    public void shouldReturnTreeHeight() {
        addValueToTree(INPUT_VALUES);
        assertEquals(8, tree.getTreeHeight());
    }

    @Test
    public void shouldReturnTreeHeightForOneElementTree() {
        tree.add(4);
        assertEquals(1, tree.getTreeHeight());
    }

    @Test
    public void shouldReturnZeroTreeHeightForEmptyTree() {
        assertEquals(0, tree.getTreeHeight());
    }

    @Test
    public void shouldTraversInOrder() {
        addValueToTree(INPUT_VALUES);
        assertThat(tree.inOrder(), contains(IN_ORDER_EXPECTED));
        assertThat(tree.inOrderWithIteration(), contains(IN_ORDER_EXPECTED));
    }

    @Test
    public void shouldGetAllPathsForEmptyTree() {
        assertTrue(tree.allPaths().isEmpty());
    }

    @Test
    public void shouldGetAllPathsForOneElementTree() {
        tree.add(1);

        assertThat(tree.allPaths(), contains(asList(1)));
    }

    @Test
    public void shouldGetAllPathsForTwoElementTree() {
        tree.add(1);
        tree.add(3);

        assertThat(tree.allPaths(), contains(asList(1, 3)));
    }

    @Test
    public void shouldGetAllPathsForTree() {
        addValueToTree(INPUT_VALUES);

        assertThat(tree.allPaths(), contains(
                asList(PATH_ONE), asList(PATH_TWO), asList(PATH_THREE), asList(PATH_FOUR), asList(PATH_FIVE)
        ));
    }

    private void assertTree(BinaryTree<Integer> tree, Integer[] inOrder, Integer[] preOrder, Integer[] postOrder) {
        assertThat(tree.inOrder(), contains(inOrder));
        assertThat(tree.preOrder(), contains(preOrder));
        assertThat(tree.postOrder(), contains(postOrder));
    }

    private void addValueToTree(Integer[] values) {
        for (Integer value : values) tree.add(value);
    }
}