package taxicab;

import java.util.List;

import org.junit.Test;

import taxicab.Taxicab.TaxicabNumber;

public class TaxicabTest {

    @Test
    public void test() {
        Taxicab taxicab = new Taxicab();
        List<TaxicabNumber> a = taxicab.findTaxicabNumber(12);
        System.out.println(a.get(0).n);
    }
}