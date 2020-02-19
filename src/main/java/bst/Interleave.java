package bst;

import java.util.ArrayList;
import java.util.List;

public class Interleave {

    public static List<List<Integer>> interleave(List<Integer> a, List<Integer> b, List<Integer> prefix) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (a.size() == 0 || b.size() == 0) {
            List<Integer> interleaved = new ArrayList<>(prefix);
            interleaved.addAll(a);
            interleaved.addAll(b);
            result.add(interleaved);
        } else {
            List<Integer> prefixWithA = new ArrayList<>(prefix);
            prefixWithA.add(a.get(0));
            result.addAll(interleave(a.subList(1, a.size()), b, prefixWithA));
    
            List<Integer> prefixWithB = new ArrayList<>(prefix);
            prefixWithB.add(b.get(0));
            result.addAll(interleave(a, b.subList(1, b.size()), prefixWithB));
    
        }

        return result;
    }    
}