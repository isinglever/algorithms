package io.github.sorting;

public class Insertion {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && Tools.less(a[j], a[j -1]); j--)
                Tools.exch(a, j, j-1);
        }
    }

    public static void main(String[] args) {
        /*********************
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
         *************************************/
        //String[] a = new String[5];
        String[] a = {String.valueOf(1), String.valueOf(4),
                String.valueOf(3), String.valueOf(5),
                String.valueOf(1), String.valueOf(2)};
        sort(a);
        System.out.println(a.length);
        System.out.println(Tools.isSorted(a));
        Tools.show(a);

    }
}
