package org.interview.datastructures.list;

import java.util.Collection;

import static org.interview.utils.Math.ge;

public class LinkedList<T extends Comparable<T>> {


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

    public void sort() {
        head = sort(head);
    }

    private Item<T> sort(Item<T> headItem) {
        if (headItem == null || headItem.next == null) {
            return headItem;
        } else {
            Item<T> middle = getMiddle(headItem);
            Item<T> newHead = middle.next;
            middle.next = null;
            Item<T> headA = sort(headItem);
            Item<T> headB = sort(newHead);
            return merge(headA, headB);
        }
    }

    private Item<T> getMiddle(Item<T> head) {
        Item<T> iterator = head;
        Item<T> middle = null;

        while (iterator != null) {
            iterator = iterator.next;
            if (iterator != null) {
                middle = middle == null ? head : middle.next;
                iterator = iterator.next;
            }
        }
        return middle;
    }

    private Item<T> merge(Item<T> headA, Item<T> headB) {
        LinkedList<T> list = new LinkedList<T>();
        Item<T> iteratorA = headA;
        Item<T> iteratorB = headB;
        while (iteratorA != null && iteratorB != null) {
            if (ge(iteratorA.value, iteratorB.value)) {
                list.add(iteratorB.value);
                iteratorB = iteratorB.next;
            } else {
                list.add(iteratorA.value);
                iteratorA = iteratorA.next;
            }
        }

        while (iteratorA != null) {
            list.add(iteratorA.value);
            iteratorA = iteratorA.next;
        }

        while (iteratorB != null) {
            list.add(iteratorB.value);
            iteratorB = iteratorB.next;
        }
        return list.head;
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
