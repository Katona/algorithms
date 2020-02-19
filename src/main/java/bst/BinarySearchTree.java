package bst;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BinarySearchTree<K, V> implements Iterable<V> {

    private static class Node<K, V> {
        public final K key;
        public final V value;
        public final Node<K, V> left;
        public final Node<K, V> right;
        public final int size;

        public Node(K key, V value, Node<K, V> left, Node<K, V> right, int size) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.size = size;
        }
    }

    private Comparator<K> comparator;
    private Node<K, V> root;

    public BinarySearchTree(Comparator<K> comparator) {
        this.comparator = comparator;
    }

    public void add(K key, V value) {
        this.root = add(this.root, key, value);
    }

    public Node<K, V> add(Node<K, V> node, K key, V value) {
        Node<K, V> result;
        if (node == null) {
            result = new Node<>(key, value, null, null, 1);
        } else {
            if (comparator.compare(key, node.key) < 0) {
                Node<K, V> newLeft = add(node.left, key, value);
                result = new Node<>(node.key, node.value, newLeft, node.right, size(newLeft) + 1 + size(node.right));
            } else {
                Node<K, V> newRight = add(node.right, key, value);
                result = new Node<>(node.key, node.value, node.left, newRight, size(node.left) + 1 + size(newRight));
            }
        }
        return result;
    }

    private int size(Node<K, V> node) {
        return node != null ? node.size : 0;
    }
    
    public int depth() {
        return depth(root);
    }

    private int depth(Node<K, V> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    public V get(K key) {
        Node<K, V> node = findNode(root, key);
        return node != null ? node.value : null;
    }

    private Node<K, V> findNode(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        } else if (node.key == key) {
            return node;
        } else if (comparator.compare(key, node.key) < 0) {
            return findNode(node.left, key);
        } else {
            return findNode(node.right, key);
        }
    }

    @Override
    public Iterator<V> iterator() {
        Queue<Node<K,V>> queue = new LinkedList<>(Collections.singleton(root));
        return new Iterator<V>() {
            
			@Override
			public boolean hasNext() {
				return !queue.isEmpty() && queue.peek() != null;
			}

			@Override
			public V next() {
                Node<K, V> current = queue.remove();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
				return current.value;
			}
        };
    }

	public void delete(K key) {
        checkNotEmpty();
        root = delete(root, key);
    }
    
    private Node<K, V> delete(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        if (comparator.compare(node.key, key) == 0) {
            Node<K, V> successor;
            if (node.right != null) {
                successor = minNode(node.right);
                Node<K, V> newRight = deleteMin(node.right);
                return new Node<K, V>(successor.key, successor.value, node.left, newRight, size(node.left) + 1 + size(newRight));
            } else if (node.left != null) {
                successor = maxNode(node.left);
                Node<K, V> newLeft = deleteMax(node.left);
                return new Node<K, V>(successor.key, successor.value, newLeft, node.right, size(newLeft) + 1 + size(node.right));
            } else {
                return null;
            }
 
        } else if (comparator.compare(key, node.key) < 0) {
            Node<K, V> newLeft = delete(node.left, key);
            return new Node<K,V>(node.key, node.value, newLeft, node.right, size(newLeft) + 1 + size(node.right));
        } else {
            Node<K, V> newRight = delete(node.right, key);
            return new Node<K,V>(node.key, node.value, node.left, newRight, size(node.left) + 1 + size(newRight));
        }
    }

    public void deleteMin() {
        checkNotEmpty();
        this.root = deleteMin(root);
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.left != null) {
            return new Node<>(node.key, node.value, deleteMin(node.left), node.right, node.size - 1);
        } else {
            return node.right;
        }
    }

    public void deleteMax() {
        checkNotEmpty();
        this.root = deleteMax(root);
    }

    private Node<K, V> deleteMax(Node<K, V> node) {
        if (node.right != null) {
            return new Node<>(node.key, node.value, node.left, deleteMax(node.right), node.size - 1);
        } else {
            return node.left;
        }
    }

    public V min() {
        return minNode(this.root).value;
    }

    private Node<K, V> minNode(Node<K, V> root) {
        Node<K, V> minNode = root;
        while (minNode.left != null) minNode = minNode.left;
        return minNode;
    }

    public V max() {
        return maxNode(root).value;
    }

    private Node<K, V> maxNode(Node<K, V> root) {
        Node<K, V> maxNode = root;
        while (maxNode.right != null) maxNode = maxNode.right;
        return maxNode;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return isEmpty() ? 0 : root.size;
    }

    
    private void checkNotEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }
}