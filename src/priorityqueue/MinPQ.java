package priorityqueue;

public class MinPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public MinPQ(int capacity) {

        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }

    public void insert(Key key) {
        pq[++N] = key;
        swim(N);
    }

    private void swim(int k) {

        while (k > 1 && less(k, k/2)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {

            int j = 2 * k;
            if ( j < N && less(j+1, j)) j++;
            if (!less(j, k)) break;

            exch(j, k);
            k = j;

        }
    }

    public Key delMin() {

        Key min = pq[1];
        exch(1, N--);
        sink(1);

        pq[N+1] = null;
        return min;
    }

    private void exch(int i, int j) {

        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean less(int i, int j) {

        return pq[i].compareTo(pq[j]) < 0;
    }
}
