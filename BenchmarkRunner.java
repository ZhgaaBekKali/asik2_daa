package asik2_daa;

import java.util.*;

public class BenchmarkRunner {
    public static void main(String[] args) {
        testWithSizes();
    }

    public static void testWithSizes() {
        int[] sizes = {100, 1000, 10000, 100000};
        PerformanceTracker tracker = new PerformanceTracker();

        for (int size : sizes) {
            System.out.println("\nTesting with size: " + size);
            testHeapOperations(size, tracker);
        }

        tracker.printMetrics();
    }

    private static void testHeapOperations(int size, PerformanceTracker tracker) {
        MinHeap heap = new MinHeap();
        Random random = new Random(42);

        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            heap.insert(random.nextInt(1000));
        }
        long insertTime = (System.nanoTime() - startTime) / 1_000_000;

        tracker.trackTime("insert_" + size, insertTime);
        tracker.trackOperations("insert_" + size, heap.getComparisons(), heap.getSwaps());

        System.out.printf("Insert %d elements: %d ms, comparisons: %d, swaps: %d%n",
                size, insertTime, heap.getComparisons(), heap.getSwaps());

        heap.resetMetrics();

        startTime = System.nanoTime();
        while (!heap.isEmpty()) {
            heap.extractMin();
        }
        long extractTime = (System.nanoTime() - startTime) / 1_000_000;

        tracker.trackTime("extract_" + size, extractTime);
        tracker.trackOperations("extract_" + size, heap.getComparisons(), heap.getSwaps());

        System.out.printf("Extract all: %d ms, comparisons: %d, swaps: %d%n",
                extractTime, heap.getComparisons(), heap.getSwaps());
    }
}