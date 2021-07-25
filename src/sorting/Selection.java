package sorting;

import sorting.Tools;

import java.util.ArrayList;
import java.util.List;
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
        List<String> list = new ArrayList<String>();
        Scanner read = new Scanner(System.in);
        do {
            System.out.println("Current list is " + list);
            System.out.println("Add more? (y/n)");
            if (read.next().startsWith("y")) {
                System.out.println("Enter : ");
                list.add(read.next());
            } else {
                break;
            }
        } while (true);
        read.close();
        System.out.println("List is " + list);
        String[] a = list.toArray(new String[0]);
        //String[] a = read.delimiter().split(System.lineSeparator());
        sort(a);
        Tools.show(a);

    }
}
