package taxicab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Taxicab {

    private static class TaxicabTerm {
        public final int a;
        public final int b;
        public final long n;

        public TaxicabTerm(int a, int b, long n) {
            this.a = a;
            this.b = b;
            this.n = n;
        }
    }

    public static class TaxicabNumber {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final long n;

        public TaxicabNumber(int a, int b, int c, int d, long n) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
            this.n = n;
        }
    }

    public List<TaxicabNumber> findTaxicabNumber(int n) {
        List<TaxicabTerm> allCombinations = new ArrayList<>();
        for (int a = 1; a < n; a++) {
            for (int b = a + 1; b <= n; b++) {
                long aCube = a * a * a;
                long bCube = b * b * b;
                allCombinations.add(new TaxicabTerm(a, b, aCube + bCube));        
            }
        }
        Collections.sort(allCombinations, (a, b) -> Long.compare(a.n,  b.n));
        long currentTaxicab = -1;
        List<TaxicabTerm> buffer = new ArrayList<>();
        List<TaxicabNumber> taxicabNumbers = new ArrayList<>();
        for (TaxicabTerm taxicabNumber : allCombinations) {
            if (taxicabNumber.n == currentTaxicab) {
                buffer.add(taxicabNumber);
            } else {
                if (buffer.size() > 1) {
                    taxicabNumbers.add(new TaxicabNumber(buffer.get(0).a, buffer.get(0).b, buffer.get(1).a, buffer.get(1).b, currentTaxicab));
                } 
                buffer.clear();
                buffer.add(taxicabNumber);
                currentTaxicab = taxicabNumber.n;
            }
        }
        if (buffer.size() > 1) {
            taxicabNumbers.add(new TaxicabNumber(buffer.get(0).a, buffer.get(0).b, buffer.get(1).a, buffer.get(1).b, currentTaxicab));
        } 
        return taxicabNumbers;
    }
}