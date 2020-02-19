package binaryheap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class BinaryHeapTest {

    private BinaryHeap<Integer> binaryHeap;

    @Before
    public void setup() {
        binaryHeap = new BinaryHeap<>((a, b) -> a - b);
    }

    @Test
    public void testAdd() {
        binaryHeap.add(3);
        assertEquals(3, binaryHeap.head().intValue());
        binaryHeap.add(2);
        assertEquals(3, binaryHeap.head().intValue());
        binaryHeap.add(10);
        assertEquals(10, binaryHeap.head().intValue());
        assertEquals(3, binaryHeap.size());
    }

    @Test
    public void testRemove() {
        binaryHeap.add(10);
        binaryHeap.add(2);
        binaryHeap.add(1);
        binaryHeap.add(11);
        assertEquals(11, binaryHeap.removeHead().intValue());
        assertEquals(10, binaryHeap.removeHead().intValue());
        assertEquals(2, binaryHeap.removeHead().intValue());
        assertEquals(1, binaryHeap.removeHead().intValue());
        assertEquals(0, binaryHeap.size());

    }

    @Test
    public void complexTest() {
        Random rnd = new Random();
        for (int i = 0; i < 100; i++) {
            binaryHeap.add(rnd.nextInt(100));
        }
        Integer previous = Integer.MAX_VALUE;
        while (binaryHeap.size() > 0) {
            Integer current = binaryHeap.removeHead();
            System.out.println(current);
            assertTrue(current <= previous);
            previous = current;
        }
    }


}