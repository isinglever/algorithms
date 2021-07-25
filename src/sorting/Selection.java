package sorting;

import sorting.Tools;
import java.util.Scanner;

public class Selection {
    public static void  sort(Comparable[] a) {
        int n = a.length;
        for (int i =0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (Tools.less(a[j], a[min])) {
                    min = j;
                    Tools.exch(a, i, min);
                }

            }
        }
    }
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        String[] a = read.delimiter().split(System.lineSeparator());
        sort(a);

    }
}
