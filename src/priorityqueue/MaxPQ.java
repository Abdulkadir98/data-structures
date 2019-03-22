package priorityqueue;

import java.util.Iterator;

/**
 *
 * @param <Key>
 *     Time complexity:
 *     Insert operation: Log N
 *     Delete max operation: Log N
 *     retrieve max: Log N
 */
public class MaxPQ<Key extends Comparable<Key>> implements Iterable<Key> {

    private Key[] pq;
    private int N = 0;

    public MaxPQ(int capacity) {

        pq = (Key[]) new Comparable[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(Key key) {

        pq[++N] = key;
        swim(N);

    }

    // To promote a node if it's greater than its parent and maintain heap order
    private void swim(int k) {

        while (k > 1 && less(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }

    // To demote a node if it's smaller than its children and maintain heap order
    private void sink(int k) {

        while (2*k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;

            exch(k ,j);
            k = j;
        }
    }

    public Key delMax() {

        Key max = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;  //prevent loitering

        return max;
    }

    private boolean less(int i, int j) {

        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {

        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    @Override
    public Iterator<Key> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Key> {

        int current = 1;
        @Override
        public boolean hasNext() {
            return current <= N;
        }

        @Override
        public Key next() {
            return pq[current++];
        }
    }
}
