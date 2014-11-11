package org.interview.datastructures.heap;

import static org.interview.utils.Math.gt;
import static org.interview.utils.Swap.swap;

public class Heap<T extends Comparable<T>> {
    protected final T[] heap;
    protected int heapCapacity;

    public Heap(T[] array) {
        heap = array;
        heapCapacity = array.length;
    }

    public int getCapacity() {
        return heapCapacity;
    }

    public T min() {
        if (heapCapacity <= 0) throw new IllegalArgumentException("Heap is empty");
        T min = heap[0];
        heapCapacity--;
        swap(heap, 0, heapCapacity);
        heap[heapCapacity] = null;
        if (heapCapacity > 0)
            heapifyMin(0);
        return min;
    }

    public void heapify() {
        int i = heap.length / 2 - 1;
        while (i-- > 0) {
            heapifyMin(i);
        }
    }

    private void heapifyMin(int i) {
        if (heap[i] == null) throw new IllegalArgumentException("Heap can't contain nulls");
        int current = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < heapCapacity && gt(heap[current], heap[left])) current = left;
        if (right < heapCapacity && gt(heap[current], heap[right])) current = right;
        if (current != i) {
            swap(heap, current, i);
            heapifyMin(current);
        }
    }

}
