package tree;

public class Node {
    public final int value;
    public final Node left;
    public final Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + value + ", " + left + ", " + right + ")";
    }
}