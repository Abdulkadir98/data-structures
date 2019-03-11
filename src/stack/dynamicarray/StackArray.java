package stack.dynamicarray;

import java.util.Arrays;
import java.util.Iterator;

public class StackArray<Item> implements Iterable<Item> {

    private Item[] st;
    private int N = 0;

    public StackArray() {
        st = (Item[]) new Object[1];
    }

    public boolean isEmpty() {

        return N == 0;
    }

    public void push(Item item){

        if (N == st.length) resize(2 * st.length);
        st[N++] = item;
    }

    private void resize(int capacity) {

        st = Arrays.copyOf(st, capacity);
    }

    public Item pop() {

        Item item = st[--N];
        st[N] = null;

        if (N > 0 && N == st.length/4 ) resize(st.length/2);

        return item;
    }

    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        int top = N;
        @Override
        public boolean hasNext() {
            return top > 0;
        }

        @Override
        public Item next() {
            return st[--top];
        }
    }
}
