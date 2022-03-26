package io.github.sorting;

public class InsertionSort {
    public void sort(int[] arr) {
        InsertionSort.insertionSort(arr);
    } 
    
    private static void insertionSort(int[] arr) {
        if(arr == null) return;
        final int N = arr.length;
        for(int i = 1; i < N; i++) {
            for(int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
               swap(arr, j, j-1); 
            }
        }
    }

    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] array = {10, 4, 6, 8, 13, 2, 3};
        InsertionSort sorter = new InsertionSort();
        sorter.sort(array);
        // Prints:
        // [2, 3, 4, 6, 8, 10, 13]
        System.out.println(java.util.Arrays.toString(array));
    }
}
