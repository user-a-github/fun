package org.interview.datastructures.tree;


import java.util.*;

import static org.interview.utils.Math.ge;

public class BinaryTree<T extends Comparable<T>> {
    private static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> root;

    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("Can't add nulls to the tree.");
        if (root == null) {
            root = new Node<T>(item);
        } else {
            addToTree(item);
        }
    }

    public List<T> breadthFirst() {
        List<T> nodeValues = new ArrayList<T>();
        if (root != null) {
            Queue<Node<T>> queue = new LinkedList<Node<T>>();
            queue.add(root);
            Node<T> it;
            while (!queue.isEmpty()) {
                it = queue.remove();
                nodeValues.add(it.value);
                if (it.left != null) queue.add(it.left);
                if (it.right != null) queue.add(it.right);
            }
        }
        return nodeValues;
    }

    public List<T> inOrderWithIteration() {
        List<T> nodeValues = new ArrayList<T>();
        if (root != null) {
            Stack<Node<T>> stack = new Stack<Node<T>>();
            Node<T> it = root;
            while (!stack.isEmpty() || it != null) {
                if (it != null) {
                    stack.add(it);
                    it = it.left;
                } else {
                    it = stack.pop();
                    nodeValues.add(it.value);
                    it = it.right;
                }
            }
        }
        return nodeValues;
    }

    public List<T> inOrder() {
        List<T> nodeValues = new ArrayList<T>();
        inOrder(root, nodeValues);
        return nodeValues;
    }

    public List<T> preOrder() {
        List<T> nodeValues = new ArrayList<T>();
        preOrder(root, nodeValues);
        return nodeValues;
    }

    public List<T> postOrder() {
        List<T> nodeValues = new ArrayList<T>();
        postOrder(root, nodeValues);
        return nodeValues;
    }

    private void inOrder(Node<T> node, List<T> values) {
        if (node != null) {
            inOrder(node.left, values);
            values.add(node.value);
            inOrder(node.right, values);
        }
    }

    private void preOrder(Node<T> node, List<T> values) {
        if (node != null) {
            values.add(node.value);
            preOrder(node.left, values);
            preOrder(node.right, values);
        }
    }

    private void postOrder(Node<T> node, List<T> values) {
        if (node != null) {
            postOrder(node.left, values);
            postOrder(node.right, values);
            values.add(node.value);
        }
    }

    private void addToTree(T item) {
        Node<T> it = root;
        while (it != null) {
            if (ge(item, it.value)) {
                if (it.right != null) {
                    it = it.right;
                } else {
                    it.right = new Node<T>(item);
                    it = null;
                }
            } else {
                if (it.left != null) {
                    it = it.left;
                } else {
                    it.left = new Node<T>(item);
                    it = null;
                }
            }
        }
    }
}