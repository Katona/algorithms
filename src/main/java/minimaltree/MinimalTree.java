package minimaltree;

import tree.Node;

public class MinimalTree {

    public Node create(int[] array) {
        return minimalTree(array, 0, array.length);
    }

    private Node minimalTree(int[] array, int lo, int hi) {
        Node result = null;
        if (hi - lo == 1) {
            result = new Node(array[lo], null, null);
        } else if (hi - lo == 0) {
            result = null;
        } else {
            int middle = (lo + hi) / 2;
            result = new Node(array[middle], minimalTree(array, lo, middle), minimalTree(array, middle + 1, hi));
        }
        return result;
    }
}