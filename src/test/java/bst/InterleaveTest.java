package bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class InterleaveTest {

    @Test
    public void testBasic() {
        List<List<Integer>> interleaveResult = Interleave.interleave(Arrays.asList(1, 2), Arrays.asList(3, 4), new ArrayList<>());

        System.out.println(interleaveResult);
    }
}