package org.interview.datastructures.graph;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.interview.datastructures.graph.Graph.Vertex;
import static org.interview.datastructures.graph.Graph.Vertex.Color.BLACK;
import static org.interview.datastructures.graph.Graph.Vertex.Color.WHITE;
import static org.interview.datastructures.graph.GraphBreadthFirstTraversal.dfs;
import static org.junit.Assert.assertThat;

public class GraphBreadthFirstTraversalTest {

    private static Vertex VERTEX_ONE = new Vertex(1);
    private static Vertex VERTEX_TWO = new Vertex(2);
    private static Vertex VERTEX_THREE = new Vertex(3);
    private static Vertex VERTEX_FOUR = new Vertex(4);
    private static Vertex VERTEX_FIVE = new Vertex(5);
    private static Vertex VERTEX_SIX = new Vertex(6);
    private static Vertex VERTEX_SEVEN = new Vertex(7);

    private static Vertex VERTEX_ONE_EXPECTED = new Vertex(1);
    private static Vertex VERTEX_TWO_EXPECTED = new Vertex(2);
    private static Vertex VERTEX_THREE_EXPECTED = new Vertex(3);
    private static Vertex VERTEX_FOUR_EXPECTED = new Vertex(4);
    private static Vertex VERTEX_FIVE_EXPECTED = new Vertex(5);
    private static Vertex VERTEX_SIX_EXPECTED = new Vertex(6);
    private static Vertex VERTEX_SEVEN_EXPECTED = new Vertex(7);

    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();

        VERTEX_ONE.setColor(WHITE);
        VERTEX_TWO.setColor(WHITE);
        VERTEX_THREE.setColor(WHITE);
        VERTEX_FOUR.setColor(WHITE);
        VERTEX_FIVE.setColor(WHITE);
        VERTEX_SIX.setColor(WHITE);
        VERTEX_SEVEN.setColor(WHITE);

        VERTEX_ONE_EXPECTED.setColor(BLACK);
        VERTEX_TWO_EXPECTED.setColor(BLACK);
        VERTEX_THREE_EXPECTED.setColor(BLACK);
        VERTEX_FOUR_EXPECTED.setColor(BLACK);
        VERTEX_FIVE_EXPECTED.setColor(BLACK);
        VERTEX_SIX_EXPECTED.setColor(BLACK);
        VERTEX_SEVEN_EXPECTED.setColor(BLACK);
    }

    @Test
    public void shouldDFSTraverseGraph() {
        graph.addEdge(VERTEX_ONE, VERTEX_TWO, 1);
        graph.addEdge(VERTEX_ONE, VERTEX_FIVE, 1);
        graph.addEdge(VERTEX_ONE, VERTEX_SIX, 1);
        graph.addEdge(VERTEX_TWO, VERTEX_THREE, 1);
        graph.addEdge(VERTEX_THREE, VERTEX_FOUR, 1);
        graph.addEdge(VERTEX_FIVE, VERTEX_FOUR, 1);
        graph.addEdge(VERTEX_SIX, VERTEX_SEVEN, 1);

        assertThat(dfs(graph, VERTEX_ONE), contains(
                VERTEX_ONE_EXPECTED, VERTEX_TWO_EXPECTED, VERTEX_FIVE_EXPECTED,
                VERTEX_SIX_EXPECTED, VERTEX_THREE_EXPECTED, VERTEX_FOUR_EXPECTED, VERTEX_SEVEN_EXPECTED
        ));
    }

    @Test
    public void shouldDFSTraverseOneVertexGraph() {
        graph.addVertex(VERTEX_ONE);

        assertThat(dfs(graph, VERTEX_ONE), contains(
                VERTEX_ONE_EXPECTED
        ));
    }

    @Test
    public void shouldDFSTraverseTwoVerticesGraph() {
        graph.addEdge(VERTEX_ONE, VERTEX_TWO, 1);

        assertThat(dfs(graph, VERTEX_ONE), contains(
                VERTEX_ONE_EXPECTED, VERTEX_TWO_EXPECTED
        ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotTraverseEmptyGraph() {
        dfs(graph, VERTEX_ONE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotTraverseGraphWithNullStartVertex() {
        graph.addEdge(VERTEX_ONE, VERTEX_TWO, 1);

        dfs(graph, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotTraverseGraphWithIllegalStartVertex() {
        graph.addEdge(VERTEX_ONE, VERTEX_TWO, 1);
        graph.addEdge(VERTEX_ONE, VERTEX_FIVE, 1);
        graph.addEdge(VERTEX_ONE, VERTEX_SIX, 1);
        graph.addEdge(VERTEX_TWO, VERTEX_THREE, 1);
        graph.addEdge(VERTEX_THREE, VERTEX_FOUR, 1);
        graph.addEdge(VERTEX_FIVE, VERTEX_FOUR, 1);

        dfs(graph, VERTEX_SEVEN);
    }

}