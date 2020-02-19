package sort;

import java.util.Comparator;
import java.util.Random;

public class QuickSort<T> {

    static class Range {
        int start;
        int end;
        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public void sort(T[] input, Comparator<T> comparator) {
        quickSort(input, comparator, 0, input.length);
    }

    private void quickSort(T[] input, Comparator<T> comparator, int lo, int hi) {
        if (lo >= hi - 1) {
            return;
        }
        Range r =  partition(input, comparator, lo, hi);
        quickSort(input, comparator, lo, r.start);
        quickSort(input, comparator, r.end, hi);
    }

    void shuffle(T[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            swap(array, random.nextInt(i + 1), i);
        }
    }

    Range partition(T[] array, Comparator<T> comparator, int lo, int hi) {
        int lt = lo;
        int gt = hi - 1;
        T pivot = array[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = comparator.compare(array[i], pivot);
            if (cmp < 0) {
                swap(array, lt, i);
                lt++;
                i++;
            } else if (cmp > 0) {
                swap(array, gt, i);
                gt--;
            } else {
                i++;
            }
        }
        return new Range(lt, gt + 1);
    }

    private void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}