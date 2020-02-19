package sort;

public class PartiallySorted {

    public void sort(int[] partiallySortedList, int k) {
        for (int i = 0; i < k; i++) {
            bubbleUp(partiallySortedList);
            bubbleDown(partiallySortedList);
        }
    }

    private void bubbleUp(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) { 
                swap(array, i, i - 1);
            }
        }
    }

    private void bubbleDown(int[] array) {
        for (int i = array.length - 2; i <= 0; i--) {
            if (array[i] > array[i + 1]) { 
                swap(array, i, i + 1);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}