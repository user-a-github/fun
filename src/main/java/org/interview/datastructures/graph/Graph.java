package org.interview.datastructures.graph;

import java.util.*;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.interview.datastructures.graph.Graph.Vertex.Color.WHITE;

public class Graph {

    public static class Edge implements Comparable<Edge> {
        public final Vertex from;
        public final Vertex to;
        public final int weight;

        public Edge(Vertex from, Vertex to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return new Integer(to.id).compareTo(o.to.id);
        }

        @Override
        public boolean equals(Object obj) {
            return reflectionEquals(this, obj);
        }

        @Override
        public int hashCode() {
            return reflectionHashCode(this);
        }

        @Override
        public String toString() {
            return reflectionToString(this);
        }
    }

    public static class Vertex implements Comparable<Vertex> {
        public enum Color {
            WHITE, GREY, BLACK
        }

        public final int id;
        private Color color;

        public Vertex(int id) {
            this.id = id;
            color = WHITE;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        @Override
        public int compareTo(Vertex v) {
            return new Integer(id).compareTo(v.id);
        }

        @Override
        public boolean equals(Object obj) {
            return reflectionEquals(this, obj);
        }

        @Override
        public String toString() {
            return reflectionToString(this);
        }
    }

    protected final Map<Vertex, Set<Edge>> graph;

    public Graph() {
        graph = new TreeMap<>();
    }

    public Graph addVertex(Vertex v) {
        assertNullVertex(v);
        if (!graph.containsKey(v)) {
            graph.put(v, new TreeSet<Edge>());
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

    public Set<Edge> getEdges(Vertex v) {
        return graph.getOrDefault(v, new HashSet<Edge>());
    }

    private void assertNullVertex(Vertex v) {
        if (v == null) throw new IllegalArgumentException("Can't add null vertex.");
    }
}
