package sorting.insertionsort;

public class Insertion {

    public static void sort(Comparable[] a) {

        int N = a.length;
        for (int i=0; i < N; i++)
            for (int j=i; j > 0 && less(a[j], a[j-1]); j--) {

                exch(a, j, j-1);
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){

        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
