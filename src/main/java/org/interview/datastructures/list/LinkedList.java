package org.interview.datastructures.list;

import java.util.Collection;

public class LinkedList<T> {


    private static class Item<T> {
        T value;
        Item<T> next;

        Item(T value, Item<T> next) {
            this.value = value;
            this.next = next;
        }

    }

    private Item<T> head;

    public void add(T element) {
        if (isEmpty()) {
            head = new Item<T>(element, null);
        } else {
            getTail().next = new Item<T>(element, null);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Collection<T> asCollection() {
        Collection<T> collection = new java.util.LinkedList<T>();
        Item<T> it = head;
        while (it != null) {
            collection.add(it.value);
            it = it.next;
        }
        return collection;
    }

    public void reverseWithRecursion() {
        if (!isEmpty() && head.next != null) reverseWithRecursion(head);
    }

    public void reverseWithIteration() {
        if (!isEmpty() && head.next != null) reverseWithIteration(head);
    }

    private void reverseWithRecursion(Item<T> current) {
        if (current.next == null) {
            head = current;
            return;
        }
        reverseWithRecursion(current.next);
        current.next.next = current;
        current.next = null;
    }

    private void reverseWithIteration(Item<T> h) {
        Item<T> prev = null;
        Item<T> current = h;
        Item<T> next = current.next;
        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        head = current;
        head.next = prev;
    }

    private Item<T> getTail() {
        Item<T> it = head;
        while (it.next != null) it = it.next;
        return it;
    }
}
