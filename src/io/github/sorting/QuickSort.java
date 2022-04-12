/**
 * @author : Ori
 * @date : 4/12/2022 10:11 AM 
 *@description: Quick Sort
 */
package io.github.sorting;

public class QuickSort {
    private int[] array;
    public QuickSort(int[] array) {
        this.array = array;
    }
    
    public void sort() {
        quickSort(array, 0, array.length - 1);
    }
    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * @author : Ori
     * @date : 4/12/2022 10:01 AM 
     * @param src : 
     * @param begin : 
     * @param end : 
     * @return : void
     *@description: 
     */
    private void quickSort(int[] src, int begin, int end) {
        if (begin < end) {
            int key = src[begin];
            int i = begin;
            int j = end;
            while (i < j) {
                while (i < j && src[j] > key) {
                    j--;
                }
                if (i < j) {
                    src[i] = src[j];
                    i++;
                }
                while (i < j && src[i] < key) {
                    i++;
                }
                if (i < j) {
                    src[j] = src[i];
                    j--;
                }src[i] = key;
                quickSort(src, begin, i - 1);
                quickSort(src, i + 1, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {5,6,3,5,8,1,9,3,2};
        QuickSort quickSort = new QuickSort(array);
        quickSort.sort();
        quickSort.print();
    }
}
