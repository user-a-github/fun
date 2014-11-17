package org.interview.datastructures.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

public class Graph {
    public static class Edge {
        public final Vertex from;
        public final Vertex to;
        public final int weight;

        public Edge(Vertex from, Vertex to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object obj) {
            return reflectionEquals(this, obj);
        }

        @Override
        public int hashCode() {
            return reflectionHashCode(this);
        }
    }

    public static class Vertex {
        public final int id;

        public Vertex(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            return reflectionEquals(this, obj);
        }

        @Override
        public int hashCode() {
            return reflectionHashCode(this);
        }
    }

    protected final Map<Vertex, Set<Edge>> graph;

    protected Graph() {
        graph = new HashMap<>();
    }

    public Graph addVertex(Vertex v) {
        assertNullVertex(v);
        if (!graph.containsKey(v)) {
            graph.put(v, new HashSet<Edge>());
        }
        return this;
    }

    public void addEdge(Vertex from, Vertex to, int weight) {
        assertNullVertex(from);
        assertNullVertex(to);
        addVertex(from);
        addVertex(to);
        graph.get(from).add(new Edge(from, to, weight));
        graph.get(to).add(new Edge(to, from, weight));
    }

    private void assertNullVertex(Vertex v) {
        if (v == null) throw new IllegalArgumentException("Can't add null vertex.");
    }
}
