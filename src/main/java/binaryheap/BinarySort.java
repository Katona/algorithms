package binaryheap;

import java.util.Comparator;

public class BinarySort<T> {

    public void sort(T[] array, Comparator<T> comparator) {
        BinaryHeapOperations<T> ops = new BinaryHeapOperations<T>(comparator);
        for (int i = array.length / 2; i >= 0; i--) {
            ops.sink(array, array.length, i);
        }
        for (int n = array.length - 1; n >= 0; n--) {
            ops.swap(array, 0, n);
            ops.sink(array, n, 0);
        }
    }
}