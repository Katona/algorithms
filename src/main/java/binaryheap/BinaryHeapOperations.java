package binaryheap;

import java.util.Comparator;

class BinaryHeapOperations<T> {

    private Comparator<T> comparator;

    public BinaryHeapOperations(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void sink(T[] data, int size, int i) {
        int currentElement = i;
        while (hasChild(size, currentElement) && less(data, currentElement, greaterChildOf(data, size, currentElement))) {
            int greaterChild = greaterChildOf(data, size, currentElement);
            swap(data, currentElement, greaterChild);
            currentElement = greaterChild;
        }
    }

    private boolean hasChild(int size, int i) {
        return i * 2 + 1 < size;
    }

    private int greaterChildOf(T[] data, int size, int i) {
        int child1 = i * 2 + 1;
        int child2 = i * 2 + 2;
        int greaterChild = child1;
        
        if (child2 < size) {
            greaterChild = less(data, child1, child2) ? child2 : child1; 
        }
        return greaterChild;
    }

    public void lift(T[] data, int element) {
        int currentElement = element;
        while (currentElement != 0 && less(data, (currentElement - 1) / 2, currentElement)) {
            int parent = (currentElement - 1) / 2;
            swap(data, currentElement, parent);
            currentElement = parent;
        }
    }

    void swap(T[] data, int i, int j) {
        T tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private boolean less(T[] data, int i, int j) {
        return comparator.compare(data[i], data[j]) < 0;
    }
    

}