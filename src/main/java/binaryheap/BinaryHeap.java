package binaryheap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class BinaryHeap<T> {

    private T[] data;
    private BinaryHeapOperations<T> heapOperations;
    private int size;

    public BinaryHeap(Comparator<T> comparator) {
        this.heapOperations = new BinaryHeapOperations<>(comparator);
        this.size = 0;
        data = (T[]) new Object[1];
    }

    public T head() {
        return data[0];
    }

    public void add(T element) {
        enusreCapacity();
        data[size] = element;
        heapOperations.lift(data, size);
        size++;
    }

    public T removeHead() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        T head = data[0];
        heapOperations.swap(data, 0, size - 1);
        size--;
        heapOperations.sink(data, size, 0);
        return head;
    }

    public int size() {
        return size;
    }
    
    private void enusreCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }    
}