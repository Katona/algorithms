package bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import tree.Node;

public class BstSequences {

    public List<List<Integer>> generateSequences(Node root) {
        if (root == null) {
            return Collections.singletonList(Collections.emptyList());
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> leftSequences = generateSequences(root.left);
        List<List<Integer>> rightSequences = generateSequences(root.right);

        List<Integer> initialPrefix = Arrays.asList(root.value);
        for (List<Integer> aLeftSequence : leftSequences) {
            for (List<Integer> aRightSequence : rightSequences) {
                result.addAll(Interleave.interleave(aLeftSequence, aRightSequence, initialPrefix));
            }
        }

        return result;
    }

}