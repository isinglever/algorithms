package io.github.sorting;

public class SelectionSort {
    public void sort(int[] arr) {
        SelectionSort.selectionSort(arr);
    }
    
    private static void selectionSort(int[] arr) {
        if(arr==null) return;
        final int N = arr.length;
        for(int i=0; i<N; i++) {
            int swapIndex = i;
            for(int j=i+1; j<N; j++) {
                if(arr[i]>arr[j]) {
                    swapIndex = j;
                }
            }
            swap(arr, i, swapIndex);
        }
    }
    
/*    private int smallest(int[] arr) {
        for(int i=1; i < arr.length; i++) {
            if(arr[i]<arr[0]) {
                swap(arr,i, 0);
            }
        }
        return arr[0];
    }*/

    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    public static void main(String[] args) {
        int[] testArray = {13, 3, 9, 4, 2,};
        SelectionSort test = new SelectionSort();
        test.sort(testArray);
        System.out.println(java.util.Arrays.toString(testArray));
    }
}
