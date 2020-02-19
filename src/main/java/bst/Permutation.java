package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation<T> {

    public List<List<T>> permutations(List<T> list) {
        List<List<T>> permutations = new ArrayList<>();
        List<Integer> selectedIndices = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) { selectedIndices.add(-1); }
        boolean[] used = new boolean[list.size()];
        int n = 0;
        while (n >= 0) {
            int previousIndex = selectedIndices.get(n);
            int nextIndex = previousIndex + 1;
            while (nextIndex < list.size() && used[nextIndex]) { nextIndex++; }
            if (previousIndex >= 0) used[previousIndex] = false;
            if (nextIndex >= list.size()) {
                // backtrack
                selectedIndices.set(n, -1);
                n--;
            } else {
                selectedIndices.set(n, nextIndex);
                used[nextIndex] = true;
                if (n < selectedIndices.size() - 1) {
                    n++;
                } else {
                   // permutation found
                    permutations.add(selectedIndices.stream().map(i -> list.get(i)).collect(Collectors.toList()));
                }
            }
        }
        return permutations;
    }
}