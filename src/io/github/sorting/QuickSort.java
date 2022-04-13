/**
 * @author : Ori
 * @date : 4/12/2022 10:11 AM 
 *@description: Quick Sort
 */
package io.github.sorting;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] array) {
        QuickSort.quicksort(array);
    }
    
    public static void quicksort(int[] array) {
        if (array == null) return;
        quicksort(array, 0, array.length - 1);
    }
    
    public static void quicksort(int[] ar, int lo, int hi) {
        if (lo < hi) {
           int splitPoint = partition(ar, lo, hi);
           quicksort(ar, lo, splitPoint);
           quicksort(ar, splitPoint + 1, hi);
        }
    }
    
    private static int partition(int[] ar, int lo, int hi) {
        int pivot = ar[lo];
        int i = lo - 1, j = hi + 1;
        while (true) {
            do {
                i++;
            } while (ar[i] < pivot);
            do {
                j--;
            } while (ar[j] > pivot);
            if (i < j) swap(ar, i , j);
            else return j;
        }
    }
    
    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] array = {10,4,6,4,8,-13,2,3};
        sorter.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
