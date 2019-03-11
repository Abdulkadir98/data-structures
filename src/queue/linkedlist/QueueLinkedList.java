package queue.linkedlist;

import java.util.Iterator;

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

        Node newNode = new Node(item);

        if (rear == null)
            front = rear = newNode;

        else {
            rear.next = newNode;
            rear = newNode;
        }

    }

    public Item deQueue() {

        Item item = front.item;

        front = front.next;

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
