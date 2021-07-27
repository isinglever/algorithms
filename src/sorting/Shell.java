package sorting;

//import java.lang.*;

public class Shell {
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && Tools.less(a[j], a[j-h]); j -=h)
                Tools.exch(a, j, j-h);
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {
        String[] a = {String.valueOf(1), String.valueOf(4),
            String.valueOf(3), String.valueOf(5),
            String.valueOf(1), String.valueOf(2)};
        sort(a);
        //System.out.println(a.length);
        System.out.println(Tools.isSorted(a));
        Tools.show(a);
    }
}