package org.interview.datastructures.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

public class GraphTest {

    private static Graph.Vertex VERTEX_ONE = new Graph.Vertex(1);
    private static Graph.Vertex VERTEX_TWO = new Graph.Vertex(2);
    private static Graph.Vertex VERTEX_THREE = new Graph.Vertex(3);
    private static Graph.Vertex VERTEX_FOUR = new Graph.Vertex(4);
    private static Graph.Vertex VERTEX_FIVE = new Graph.Vertex(5);
    private static Graph.Vertex VERTEX_SIX = new Graph.Vertex(6);
    private static Graph.Vertex VERTEX_SEVEN = new Graph.Vertex(7);

    private static Graph.Vertex VERTEX_ONE_EXPECTED = new Graph.Vertex(1);
    private static Graph.Vertex VERTEX_TWO_EXPECTED = new Graph.Vertex(2);
    private static Graph.Vertex VERTEX_THREE_EXPECTED = new Graph.Vertex(3);
    private static Graph.Vertex VERTEX_FOUR_EXPECTED = new Graph.Vertex(4);
    private static Graph.Vertex VERTEX_FIVE_EXPECTED = new Graph.Vertex(5);
    private static Graph.Vertex VERTEX_SIX_EXPECTED = new Graph.Vertex(6);
    private static Graph.Vertex VERTEX_SEVEN_EXPECTED = new Graph.Vertex(7);

    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
    }

    @Test
    public void shouldAddNotNullEdges() {
        graph.addEdge(VERTEX_ONE, VERTEX_TWO, 5);
        graph.addEdge(VERTEX_ONE, VERTEX_THREE, 5);
        graph.addEdge(VERTEX_ONE, VERTEX_SIX, 1);
        graph.addEdge(VERTEX_SEVEN, VERTEX_TWO, 0);

        Map<Graph.Vertex, Set<Graph.Edge>> expectedGraph = new HashMap<>();
        expectedGraph.put(VERTEX_ONE_EXPECTED, new HashSet<Graph.Edge>());
        expectedGraph.put(VERTEX_TWO_EXPECTED, new HashSet<Graph.Edge>());
        expectedGraph.put(VERTEX_THREE_EXPECTED, new HashSet<Graph.Edge>());
        expectedGraph.put(VERTEX_SIX_EXPECTED, new HashSet<Graph.Edge>());
        expectedGraph.put(VERTEX_SEVEN_EXPECTED, new HashSet<Graph.Edge>());

        expectedGraph.get(VERTEX_ONE_EXPECTED).add(new Graph.Edge(VERTEX_ONE_EXPECTED, VERTEX_TWO_EXPECTED, 5));
        expectedGraph.get(VERTEX_TWO_EXPECTED).add(new Graph.Edge(VERTEX_TWO_EXPECTED, VERTEX_ONE_EXPECTED, 5));

        expectedGraph.get(VERTEX_ONE_EXPECTED).add(new Graph.Edge(VERTEX_ONE_EXPECTED, VERTEX_THREE_EXPECTED, 5));
        expectedGraph.get(VERTEX_THREE_EXPECTED).add(new Graph.Edge(VERTEX_THREE_EXPECTED, VERTEX_ONE_EXPECTED, 5));

        expectedGraph.get(VERTEX_ONE_EXPECTED).add(new Graph.Edge(VERTEX_ONE_EXPECTED, VERTEX_SIX_EXPECTED, 1));
        expectedGraph.get(VERTEX_SIX_EXPECTED).add(new Graph.Edge(VERTEX_SIX_EXPECTED, VERTEX_ONE_EXPECTED, 1));

        expectedGraph.get(VERTEX_TWO_EXPECTED).add(new Graph.Edge(VERTEX_TWO_EXPECTED, VERTEX_SEVEN_EXPECTED, 0));
        expectedGraph.get(VERTEX_SEVEN_EXPECTED).add(new Graph.Edge(VERTEX_SEVEN_EXPECTED, VERTEX_TWO_EXPECTED, 0));

        assertThat(graph.graph.entrySet(), everyItem(isIn(expectedGraph.entrySet())));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddEdgeIfFirstVertexParameterIsNull() {
        graph.addEdge(VERTEX_FOUR, VERTEX_TWO, 0);
        graph.addEdge(null, VERTEX_TWO, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddEdgeIfSecondVertexParameterIsNull() {
        graph.addEdge(VERTEX_FOUR, VERTEX_TWO, 0);
        graph.addEdge(VERTEX_FIVE, null, 0);
    }

    @Test
    public void shouldAddNotNullVertices() {
        graph.addVertex(VERTEX_ONE);
        graph.addVertex(VERTEX_FIVE);
        graph.addVertex(VERTEX_TWO);

        Map<Graph.Vertex, Set<Graph.Edge>> expectedGraph = new HashMap<>();
        expectedGraph.put(VERTEX_ONE_EXPECTED, new HashSet<Graph.Edge>());
        expectedGraph.put(VERTEX_FIVE_EXPECTED, new HashSet<Graph.Edge>());
        expectedGraph.put(VERTEX_TWO_EXPECTED, new HashSet<Graph.Edge>());

        assertThat(graph.graph.entrySet(), everyItem(isIn(expectedGraph.entrySet())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAddNullVertices() {
        graph.addVertex(VERTEX_ONE);
        graph.addVertex(null);
    }
}