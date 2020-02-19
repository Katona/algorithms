package sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class PartiallySortedTest {

    @Test
    public void testSort() {
        PartiallySorted partiallySorted = new PartiallySorted();
        int[] array = new int[] { 1, 5, 3 };
        partiallySorted.sort(array, 1);
        assertArrayEquals(new int[] { 1, 3, 5 }, array);

        array = new int[] { 1, 8, 7, 2 };
        partiallySorted.sort(array, 2);
        assertArrayEquals(new int[] { 1, 2, 7, 8 }, array);

    }
}