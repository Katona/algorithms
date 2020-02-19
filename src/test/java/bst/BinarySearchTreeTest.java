package bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer, Integer> tree;

    @Before
    public void setup() {
        BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<Integer, Integer>(Integer::compare);
        List<Integer> data = IntStream.range(0, 100).boxed().collect(Collectors.toList());
        Collections.shuffle(data, new Random(10));
        for (int i = 0; i < data.size(); i++) tree.add(data.get(i), i);
        this.tree = tree;
    }

    @Test
    public void testAdd() {
        HashSet<Integer> set = new HashSet<Integer>();
        for (Integer integer : tree) {
            set.add(integer);
        }
        assertEquals(100, set.size());
    }

    @Test
    public void testGet() {
        assertEquals(Integer.valueOf(91), tree.get(1));
    }

    @Test
    public void testDelete() {
        tree.delete(1);
        assertNull(tree.get(1));
    }

    @Test
    public void deleteMin() {
        for (int i = 0; i < 100; i++) {
            tree.deleteMin();
        }
        tree.deleteMin();
        assertNull(tree.get(0));
        tree.deleteMin();
        assertNull(tree.get(1));
    }

}