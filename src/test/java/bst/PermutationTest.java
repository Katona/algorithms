package bst;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class PermutationTest {   
    @Test
    public void testPermutation() {
        List<List<Integer>> permutations = new Permutation<Integer>().permutations(Arrays.asList(1, 2, 3, 4));
        System.out.println(permutations);
    }

    @Test
    public void testSimplePermutation() {
        List<List<Integer>> permutations = new Permutation<Integer>().permutations(Arrays.asList(1));
        assertEquals(1, permutations.size());
        assertEquals(Collections.singleton(1), permutations.get(0));
    }
}