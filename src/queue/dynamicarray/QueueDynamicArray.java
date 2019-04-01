package queue.dynamicarray;

import java.util.Arrays;
import java.util.Iterator;

public class QueueDynamicArray<Item> implements Iterable<Item> {

    private int front, rear;
    private Item[] q;

    public QueueDynamicArray() {

        q = (Item[]) new Object[1];
        front = rear = 0;
    }

    public boolean isEmpty() {
        return rear == 0;
    }

    public void enQueue(Item item) {

        if (rear == q.length) resize( 2 * q.length);
        q[rear++] = item;
    }

    public Item deQueue() {
        Item item = q[front++];
        return item;
    }
    private void resize(int capacity) {

        q = Arrays.copyOf(q, capacity);
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        int current = front;
        @Override
        public boolean hasNext() {
            return current < q.length && q[current] != null;
        }

        @Override
        public Item next() {

            return q[current++];
        }
    }
}
