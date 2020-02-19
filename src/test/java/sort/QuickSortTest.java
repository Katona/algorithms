package sort;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class QuickSortTest {

    @Test
    public void testPartition() {
        QuickSort<Integer> sort = new QuickSort<>();
        Integer[] test = new Integer[] { 4, 3, 2, 1 };
        QuickSort.Range r = sort.partition(test, (a, b) -> a - b, 0, test.length);
        assertEquals(3, r.start);
        assertEquals(4, r.end);
        assertArrayEquals(new Integer[] {3, 2, 1, 4 }, test);
    }

    @Test
    public void testPartition2() {
        QuickSort<Integer> sort = new QuickSort<>();
        Integer[] test = new Integer[] { 1, 3, 2};
        QuickSort.Range r = sort.partition(test, (a, b) -> a - b, 0, test.length);
        assertEquals(0, r.start);
        assertEquals(1, r.end);
        assertArrayEquals(new Integer[] {1, 2, 3}, test);
    }

    @Test
    public void testSort() {
        QuickSort<Integer> sort = new QuickSort<>();
        Integer[] test = new Integer[] { 4, 3, 2, 1 };
        sort.sort(test, (a, b) -> a - b);
        System.out.println(Arrays.toString(test));
        assertArrayEquals(new Integer[] {1, 2, 3, 4}, test);
    }
}