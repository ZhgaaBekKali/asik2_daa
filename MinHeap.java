package asik2_daa;

import java.util.*;
public class MinHeap {
    private List<Integer> heap;
    private int comparisons;
    private int swaps;

    public MinHeap() {
        heap = new ArrayList<>();
        comparisons = 0;
        swaps = 0;
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int extractMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public boolean decreaseKey(int index, int newValue) {
        if (index < 0 || index >= heap.size() || newValue >= heap.get(index)) {
            return false;
        }
        heap.set(index, newValue);
        heapifyUp(index);
        return true;
    }

    public MinHeap merge(MinHeap other) {
        MinHeap merged = new MinHeap();
        for (int val : this.heap) merged.insert(val);
        for (int val : other.heap) merged.insert(val);
        return merged;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            comparisons++;
            if (heap.get(index) >= heap.get(parent)) break;

            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            comparisons++;
            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }

            comparisons++;
            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
        swaps++;
    }

    public int getComparisons() { return comparisons; }
    public int getSwaps() { return swaps; }
    public void resetMetrics() { comparisons = 0; swaps = 0; }
    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }
}