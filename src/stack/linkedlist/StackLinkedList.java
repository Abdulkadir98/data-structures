package stack.linkedlist;

import java.util.Iterator;

public class StackLinkedList<Item> implements Iterable<Item> {

    private Node top = null;

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

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Item item) {

        Node oldTop = top;

        top = new Node(item);
        top.next = oldTop;
    }

    public Item pop() {

        Item item = top.item;

        top = top.next;
        return item;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = top;
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
