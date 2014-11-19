package org.interview.datastructures.graph;

import org.interview.datastructures.graph.Graph.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.interview.datastructures.graph.Graph.Edge;
import static org.interview.datastructures.graph.Graph.Vertex.Color.*;

public final class GraphBreadthFirstTraversal {
    public static List<Vertex> dfs(Graph graph, Vertex startVertex) {
        if (startVertex == null) throw new IllegalArgumentException("Can't start traverse from null vertex");
        if (graph.graph.isEmpty()) throw new IllegalArgumentException("Graph is empty");
        if (!graph.graph.containsKey(startVertex)) throw new IllegalArgumentException("No such vertex in the graph");

        List<Vertex> verticesList = new ArrayList<>();
        Queue<Vertex> verticesQueue = new LinkedList<>();
        startVertex.setColor(GREY);
        verticesQueue.add(startVertex);
        while (!verticesQueue.isEmpty()) {
            Vertex v = verticesQueue.remove();
            for (Edge e : graph.getEdges(v)) {
                if (e.to.getColor() == WHITE) {
                    e.to.setColor(GREY);
                    verticesQueue.add(e.to);
                }
            }
            v.setColor(BLACK);
            verticesList.add(v);
        }
        return verticesList;
    }
}
