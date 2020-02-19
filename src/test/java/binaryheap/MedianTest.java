package binaryheap;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MedianTest {

    @Test
    public void test() {
        Median median = new Median();
        median.add(1);
        assertEquals(1f, median.median(), 0.01);
        median.add(2);
        assertEquals(1.5f, median.median(), 0.01);
        median.add(3);
        assertEquals(2f, median.median(), 0.01);
        median.add(10);
        assertEquals(2.5f, median.median(), 0.01);
    }
}