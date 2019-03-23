package sorting.heapsort;


/**
 * Heap Sort: In-place sorting algorithm with O(NLogN) worst case time complexity
 */
public class Heap {

    private static int N;

    public static void sort(Comparable[] pq) {

        N = pq.length;
        for (int k = N/2; k >= 1; k--){ // counter from N/2 because right half of array is leaves and already heap-ordered
            sink(pq, k, N);
        }

        while (N > 1){
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
    }


    private static void sink(Comparable[] pq, int k, int N) {

        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    // index off by one to convert to 0-based from 1-based indexing
    // heap ordered in 1-based indexing for easier calculations
    private static boolean less(Comparable[] pq, int i, int j){
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){

        Comparable temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }
}
