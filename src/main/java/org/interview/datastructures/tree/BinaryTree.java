package org.interview.datastructures.tree;


import java.util.*;

import static java.lang.Math.max;
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
            root = new Node<>(item);
        } else {
            addToTree(item);
        }
    }

    public List<T> breadthFirst() {
        List<T> nodeValues = new ArrayList<>();
        if (root != null) {
            Queue<Node<T>> queue = new LinkedList<>();
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
        List<T> nodeValues = new ArrayList<>();
        if (root != null) {
            Node<T> it = root;
            Stack<Node<T>> stack = new Stack<>();
            while (!stack.isEmpty() || it != null) {
                if (it != null) {
                    stack.push(it);
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

    public List<T> postOrderWithIteration() {
        List<T> nodeValues = new ArrayList<>();
        if (root != null) {
            Node<T> it = root;
            Node<T> lastVisited = null;
            Node<T> peek;
            Stack<Node<T>> stack = new Stack<>();
            while (!stack.isEmpty() || it != null) {
                if (it != null) {
                    stack.push(it);
                    it = it.left;
                } else {
                    peek = stack.peek();
                    if (peek.right != null && lastVisited != peek.right) it = peek.right;
                    else {
                        nodeValues.add(peek.value);
                        lastVisited = stack.pop();
                    }
                }
            }
        }
        return nodeValues;
    }

    public List<T> preOrderWithIteration() {
        List<T> nodeValues = new ArrayList<>();
        if (root != null) {
            Node<T> it = root;
            Stack<Node<T>> stack = new Stack<>();
            while (!stack.isEmpty() || it != null) {
                if (it != null) {
                    nodeValues.add(it.value);
                    if (it.right != null) stack.push(it.right);
                    it = it.left;
                } else {
                    it = stack.pop();
                }
            }
        }
        return nodeValues;
    }

    public List<T> inOrder() {
        List<T> nodeValues = new ArrayList<>();
        inOrder(root, nodeValues);
        return nodeValues;
    }

    public List<T> preOrder() {
        List<T> nodeValues = new ArrayList<>();
        preOrder(root, nodeValues);
        return nodeValues;
    }

    public List<T> postOrder() {
        List<T> nodeValues = new ArrayList<>();
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

    public int getTreeHeight() {
        return getTreeHeight(root);
    }

    public int getTreeHeight(Node<T> node) {
        if (node == null) return 0;
        else {
            return 1 + max(getTreeHeight(node.left), getTreeHeight(node.right));
        }
    }

    public List<List<T>> allPaths() {
        List<List<T>> paths = new ArrayList<>();
        List<T> path = new ArrayList<>();
        allPaths(root, paths, path);
        return paths;
    }

    private void allPaths(Node<T> node, List<List<T>> paths, List<T> path) {
        if (node == null) return;

        path.add(node.value);

        if (node.left == null && node.right == null) {
            paths.add(new ArrayList(path));
        } else {
            allPaths(node.left, paths, path);
            allPaths(node.right, paths, path);
        }

        path.remove(path.size() - 1);
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
                    it.right = new Node<>(item);
                    it = null;
                }
            } else {
                if (it.left != null) {
                    it = it.left;
                } else {
                    it.left = new Node<>(item);
                    it = null;
                }
            }
        }
    }
}