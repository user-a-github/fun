package org.interview.datastructures.graph;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.interview.datastructures.graph.Graph.Vertex.Color.WHITE;
import static org.interview.datastructures.graph.MinimumSpanningTree.mstPrim;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MinimumSpanningTreeTest {

    private static Graph.Vertex VERTEX_ONE = new Graph.Vertex(1);
    private static Graph.Vertex VERTEX_TWO = new Graph.Vertex(2);
    private static Graph.Vertex VERTEX_THREE = new Graph.Vertex(3);
    private static Graph.Vertex VERTEX_FOUR = new Graph.Vertex(4);
    private static Graph.Vertex VERTEX_FIVE = new Graph.Vertex(5);
    private static Graph.Vertex VERTEX_SIX = new Graph.Vertex(6);
    private static Graph.Vertex VERTEX_SEVEN = new Graph.Vertex(7);
    private static Graph.Vertex VERTEX_EIGHT = new Graph.Vertex(8);

    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
        resetVerticesColorToWhite();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSpanNullGraph() {
        mstPrim(null, VERTEX_ONE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSpanGraphWithNullStartVertex() {
        graph.addEdge(VERTEX_ONE, VERTEX_TWO, 1);

        mstPrim(graph, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSpanGraphWithIllegalStartVertex() {
        graph.addEdge(VERTEX_ONE, VERTEX_TWO, 1);

        mstPrim(graph, VERTEX_EIGHT);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotSpanEmptyGraph() {
        assertTrue(mstPrim(graph, VERTEX_ONE).isEmpty());
    }

    @Test
    public void shouldSpanGraphAInPrimsOrder() {
        graph.addEdge(VERTEX_ONE, VERTEX_TWO, 5);
        graph.addEdge(VERTEX_ONE, VERTEX_SEVEN, 7);
        graph.addEdge(VERTEX_ONE, VERTEX_SIX, 12);
        graph.addEdge(VERTEX_TWO, VERTEX_SEVEN, 9);
        graph.addEdge(VERTEX_TWO, VERTEX_THREE, 7);
        graph.addEdge(VERTEX_THREE, VERTEX_SEVEN, 4);
        graph.addEdge(VERTEX_THREE, VERTEX_FIVE, 2);
        graph.addEdge(VERTEX_THREE, VERTEX_FOUR, 5);
        graph.addEdge(VERTEX_FOUR, VERTEX_FIVE, 2);
        graph.addEdge(VERTEX_FIVE, VERTEX_SEVEN, 3);
        graph.addEdge(VERTEX_FIVE, VERTEX_SIX, 7);
        graph.addEdge(VERTEX_SIX, VERTEX_SEVEN, 4);

        assertThat(mstPrim(graph, VERTEX_ONE), contains(
                VERTEX_ONE, VERTEX_TWO, VERTEX_SEVEN, VERTEX_FIVE, VERTEX_THREE, VERTEX_FOUR, VERTEX_SIX
        ));
    }

    @Test
    public void shouldSpanGraphBInPrimsOrder() {
        graph.addEdge(VERTEX_ONE, VERTEX_TWO, 2);
        graph.addEdge(VERTEX_ONE, VERTEX_FOUR, 3);
        graph.addEdge(VERTEX_ONE, VERTEX_SIX, 6);
        graph.addEdge(VERTEX_TWO, VERTEX_FOUR, 6);
        graph.addEdge(VERTEX_TWO, VERTEX_THREE, 8);
        graph.addEdge(VERTEX_THREE, VERTEX_FIVE, 5);
        graph.addEdge(VERTEX_THREE, VERTEX_FOUR, 3);
        graph.addEdge(VERTEX_FIVE, VERTEX_FOUR, 6);
        graph.addEdge(VERTEX_FIVE, VERTEX_SIX, 2);
        graph.addEdge(VERTEX_SIX, VERTEX_FOUR, 7);

        assertThat(mstPrim(graph, VERTEX_ONE), contains(
                VERTEX_ONE, VERTEX_TWO, VERTEX_FOUR, VERTEX_THREE, VERTEX_FIVE, VERTEX_SIX
        ));
    }

    @Test
    public void shouldSpanGraphCInPrimsOrder() {
        graph.addEdge(VERTEX_ONE, VERTEX_TWO, 4);
        graph.addEdge(VERTEX_ONE, VERTEX_THREE, 4);
        graph.addEdge(VERTEX_ONE, VERTEX_FOUR, 8);
        graph.addEdge(VERTEX_ONE, VERTEX_SEVEN, 8);
        graph.addEdge(VERTEX_ONE, VERTEX_EIGHT, 4);
        graph.addEdge(VERTEX_TWO, VERTEX_THREE, 4);
        graph.addEdge(VERTEX_TWO, VERTEX_FOUR, 4);
        graph.addEdge(VERTEX_THREE, VERTEX_FIVE, 4);
        graph.addEdge(VERTEX_FOUR, VERTEX_SIX, 6);
        graph.addEdge(VERTEX_FOUR, VERTEX_EIGHT, 10);
        graph.addEdge(VERTEX_SIX, VERTEX_SEVEN, 4);
        graph.addEdge(VERTEX_SIX, VERTEX_EIGHT, 4);

        assertThat(mstPrim(graph, VERTEX_ONE), contains(
                VERTEX_ONE, VERTEX_TWO, VERTEX_THREE, VERTEX_EIGHT, VERTEX_FOUR, VERTEX_FIVE, VERTEX_SIX, VERTEX_SEVEN
        ));
    }

    private void resetVerticesColorToWhite() {
        VERTEX_ONE.setColor(WHITE);
        VERTEX_TWO.setColor(WHITE);
        VERTEX_THREE.setColor(WHITE);
        VERTEX_FOUR.setColor(WHITE);
        VERTEX_FIVE.setColor(WHITE);
        VERTEX_SIX.setColor(WHITE);
        VERTEX_SEVEN.setColor(WHITE);
        VERTEX_EIGHT.setColor(WHITE);
    }

}