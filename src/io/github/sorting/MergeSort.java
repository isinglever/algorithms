package io.github.sorting;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] ar) {
        int len = ar.length;
        if (len <= 1) return ar;
        
        //split array into two parts
        int[] left = mergeSort(Arrays.copyOfRange(ar, 0, len/2));
        int[] right = mergeSort(Arrays.copyOfRange(ar, len/2, len));
        
        return merge(left, right);
    }

    // merge two sorted arrays into a larger sorted array
    private static int[] merge(int[] left, int[] right) {
/** this code block looks a little stupid
        int[] res = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                res[k] = left[i];
                k++;
                i++;
            } else {
                res[k] = right[j];
                k++;
                j++;
            }
        }
        if (i == left.length) {
            while (k < left.length + right.length) {
                res[k] = right[j];
                k++;
                j++;
            }
        } else {
            res[k] = left[i];
            k++;
            i++;
        }
        return res;
*/

        int l1 = left.length, l2 = right.length;
        int n = l1 + l2, i1 = 0, i2 = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (i1 == l1) {
                res[i] = right[i2++];
            } else if (i2 == l2) {
                res[i] =left[i1++];
            } else {
                if (left[i1] < right[i2]) {
                    res[i] = left[i1++];
                } else {
                    res[i] = right[i2++];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        array = MergeSort.mergeSort(array);
        // Prints:
        // [-13, 2, 3, 4, 4, 6, 8, 10]
        System.out.println(java.util.Arrays.toString(array));

    }
}
