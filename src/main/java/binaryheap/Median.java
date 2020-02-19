package binaryheap;

public class Median {

    private BinaryHeap<Integer> smaller = new BinaryHeap<>(Integer::compare);
    private BinaryHeap<Integer> bigger = new BinaryHeap<>((a, b) -> b - a); 

    public void add(Integer element) {
        if (size() == 0 || element < median()) {
            if (smaller.size() > bigger.size()) {
                bigger.add(smaller.removeHead());
            }
            smaller.add(element);
        } else {
            if (bigger.size() > smaller.size()) {
                smaller.add(bigger.removeHead());
            }
            bigger.add(element);
        }
    }

    public float median() {
        if (size() == 0) {
            return 0;
        }
        float median = 0f;
        if (smaller.size() > bigger.size()) {
            median = smaller.head();
        } else if (smaller.size() < bigger.size()) {
            median = bigger.head();
        } else {
            median = (bigger.head() + smaller.head()) / 2f;
        }
        return median;
    }

    public int size() {
        return bigger.size() + smaller.size();
    }
}