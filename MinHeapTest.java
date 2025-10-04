package asik2_daa;

public class MinHeapTest {
    public static void main(String[] args) {
        testEmptyHeap();
        testInsertAndExtract();
        testDecreaseKey();
        testMerge();
        System.out.println("All tests passed!");
    }

    public static void testEmptyHeap() {
        MinHeap heap = new MinHeap();
        assert heap.isEmpty();
        assert heap.size() == 0;
    }

    public static void testInsertAndExtract() {
        MinHeap heap = new MinHeap();
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);

        assert heap.extractMin() == 1;
        assert heap.extractMin() == 3;
        assert heap.extractMin() == 5;
        assert heap.extractMin() == 8;
        assert heap.isEmpty();
    }

    public static void testDecreaseKey() {
        MinHeap heap = new MinHeap();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);

        assert heap.decreaseKey(1, 5);
        assert heap.extractMin() == 5;
        assert heap.extractMin() == 10;
    }

    public static void testMerge() {
        MinHeap heap1 = new MinHeap();
        heap1.insert(2);
        heap1.insert(6);

        MinHeap heap2 = new MinHeap();
        heap2.insert(3);
        heap2.insert(1);

        MinHeap merged = heap1.merge(heap2);
        assert merged.extractMin() == 1;
        assert merged.extractMin() == 2;
        assert merged.extractMin() == 3;
        assert merged.extractMin() == 6;
    }
}