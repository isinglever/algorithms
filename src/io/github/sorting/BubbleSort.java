package io.github.sorting;

public class BubbleSort {

    public void sort(int[] values) {
        BubbleSort.bubbleSort(values);
    }
    private static void bubbleSort(int[] ar) {
        if (ar == null) {
            return;
        }

        boolean sorted;
        do {
            sorted = true;
            for (int i = 1; i < ar.length; i++) {
                if (ar[i] < ar[i - 1]) {
                    swap(ar, i - 1, i);
                    sorted = false;
                }
            }
        } while (!sorted);
        
    }
    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 8, 13, 2, 3};
        BubbleSort sorter = new BubbleSort();
        sorter.sort(array);
        // Prints:
        // [2, 3, 4, 6, 8, 10, 13]
        System.out.println(java.util.Arrays.toString(array));
    }
}
