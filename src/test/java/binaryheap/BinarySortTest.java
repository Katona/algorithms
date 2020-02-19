package binaryheap;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

public class BinarySortTest {

    @Test
    public void testSort() {
        BinarySort<Integer> sort = new BinarySort<>();
        Random rnd = new Random();
        Integer[] array = IntStream.range(0, 100).map(i -> rnd.nextInt(100)).boxed().toArray(Integer[]::new);
        Integer[] expected = Arrays.copyOf(array, array.length);
        Arrays.sort(expected);
        sort.sort(array, (a, b) -> a - b);
        assertArrayEquals(expected, array);
    }
}