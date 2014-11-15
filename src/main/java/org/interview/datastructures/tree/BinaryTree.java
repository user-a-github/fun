package org.interview.datastructures.tree;


import java.util.ArrayList;
import java.util.List;

import static org.interview.utils.Math.ge;

public class BinaryTree<T extends Comparable<T>> {
    private static class Node<T> {
        public T value;
        public Node<T> left;
        public Node<T> right;
    }

    private Node<T> root;

    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("Can't add nulls to the tree.");
        if (root == null) {
            root = new Node<T>();
            root.value = item;
        } else {
            Node<T> it = root;
            while (it != null) {
                if (ge(item, it.value)) {
                    if (it.right != null) {
                        it = it.right;
                    } else {
                        it.right = new Node<T>();
                        it.right.value = item;
                        it = null;
                    }
                } else {
                    if (it.left != null) {
                        it = it.left;
                    } else {
                        it.left = new Node<T>();
                        it.left.value = item;
                        it = null;
                    }
                }
            }
        }
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
}