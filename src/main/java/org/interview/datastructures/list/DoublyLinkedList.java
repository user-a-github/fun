package org.interview.datastructures.list;

import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedList<T> {

    private static class Item<T> {
        T value;
        Item<T> previous;
        Item<T> next;

        Item(T value, Item<T> previous, Item<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private Item<T> head;
    private Item<T> tail;

    public void add(T item) {
        if (head == null) {
            head = new Item<T>(item, null, null);
            tail = head;
        } else {
            tail.next = new Item<T>(item, tail, null);
            tail = tail.next;
        }
    }

    public List<T> toCollectionFromHead() {
        List<T> list = new LinkedList<T>();
        for (Item<T> it = head; it != null; it = it.next) {
            list.add(it.value);
        }
        return list;
    }

    public List<T> toCollectionFromTail() {
        List<T> list = new LinkedList<T>();
        for (Item<T> it = tail; it != null; it = it.previous) {
            list.add(it.value);
        }
        return list;
    }

    public void reverse() {
        if (head != null && head != tail) {
            Item<T> temp = head;
            head = tail;
            tail = temp;
            Item<T> it = head;
            while (it != null) {
                temp = it.next;
                it.next = it.previous;
                it.previous = temp;
                it = it.next;
            }
        }
    }
}
