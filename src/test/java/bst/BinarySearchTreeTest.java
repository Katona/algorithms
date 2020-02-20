package bst;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
        tree.delete(1000); // non existing
        assertEquals(100, tree.size());
        for (int i = 0; i < 100; i++) {
            tree.delete(i);
        }
        assertEquals(0, tree.size());
    }

    @Test
    public void deleteMin() {
        for (int i = 0; i < 100; i++) {
            tree.deleteMin();
        }
        assertTrue(tree.isEmpty());
    }

    @Test
    public void deleteMax() {
        for (int i = 0; i < 100; i++) {
            tree.deleteMax();
        }
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(100, tree.size());
        for (int i = 0; i < 100; i++) {
            tree.deleteMax();
        }
        assertEquals(0, tree.size());
        tree.add(1, 2);
        assertEquals(1, tree.size());
    }

    @Test
    public void testMinMax() {
        assertEquals(Integer.valueOf(39), tree.min());
        assertEquals(Integer.valueOf(79), tree.max());
    }

    @Test
    public void testFloor() {
        assertEquals(Integer.valueOf(0), tree.floor(1));
        assertEquals(Integer.valueOf(49), tree.floor(50));
        assertEquals(Integer.valueOf(99), tree.floor(100));
        assertNull(tree.floor(0));
    }

}