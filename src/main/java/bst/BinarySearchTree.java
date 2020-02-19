package bst;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import tree.Node;

public class BinarySearchTree<K, V> implements Iterable<V> {

    private static class Node<K, V> {
        public final K key;
        public final V value;
        public final Node<K, V> left;
        public final Node<K, V> right;

        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
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
            result = new Node<>(key, value, null, null);
        } else {
            if (comparator.compare(key, node.key) < 0) {
                result = new Node<>(node.key, node.value, add(node.left, key, value), node.right);
            } else {
                result = new Node<>(node.key, node.value, node.left, add(node.right, key, value));
            }
        }
        return result;
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

    }
    
    // public Node<K, V> delete(Node<K, V> node, K key) {
    //     if (comparator.compare(node.left.key, key) == 0) {

    //     }
    // }

    public void deleteMin() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        this.root = deleteMin(root);
    }

    private Node<K, V> deleteMin(Node<K, V> node) {
        if (node.left != null) {
            return new Node<>(node.key, node.value, deleteMin(node.left), node.right);
        } else {
            return node.right;
        }
    }

    public void deleteMax() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        this.root = deleteMax(root);
    }

    private Node<K, V> deleteMax(Node<K, V> node) {
        if (node.right != null) {
            return new Node<>(node.key, node.value, node.left, deleteMax(node.right));
        } else {
            return node.left;
        }
    }

    public V min() {
        Node<K, V> minNode = root;
        while (minNode.left != null) minNode = minNode.left;
        return minNode.value;
    }

    public V max() {
        Node<K, V> maxNode = root;
        while (maxNode.left != null) maxNode = maxNode.right;
        return maxNode.value;
    }
}