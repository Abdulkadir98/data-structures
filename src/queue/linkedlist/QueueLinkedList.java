package queue.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class QueueLinkedList<Item> implements Iterable<Item> {

    private Node front, rear;

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class Node {
        Item item;
        Node next;

        Node(Item item) {
            this.item = item;
        }
    }

    public QueueLinkedList() {

        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(Item item) {

        Node oldlast = rear;
        rear = new Node(item);
        rear.item = item;
        rear.next = null;

        if (isEmpty())
            front = rear;
        else
            oldlast.next = rear;


    }

    public Item deQueue() {

        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = front.item;
        front = front.next;
        if (isEmpty()) rear = null;   // to avoid loitering
        return item;
    }

    private class ListIterator implements Iterator<Item> {

        Node current = front;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;

            return item;
        }
    }
}
