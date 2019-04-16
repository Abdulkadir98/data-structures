package symboltable.redblackbst;

import queue.linkedlist.QueueLinkedList;

public class RedBlackBST<Key extends Comparable<Key>, Val> {

    private static  boolean RED = true;
    private static boolean BLACK = false;
    private Node h;

    private class Node {

        Key key;
        Val val;
        Node left;
        Node right;
        boolean color; // color of the link coming from parent node

        public Node(Key key, Val val, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    public Val get(Key key) {

        Node x = h;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }

        return null;
    }

    public void put(Key key, Val val) {

        h = put(h, key, val);
    }

    private Node put(Node h, Key key, Val val) {
        if (h == null) return new Node(key, val, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    public Iterable<Key> keys() {

        QueueLinkedList<Key> q = new QueueLinkedList<>();
        inorder(h, q);
        return q;
    }

    private void inorder(Node x, QueueLinkedList<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.enQueue(x.key);
        inorder(x.right, q);
    }

    private Node rotateLeft(Node h) {
        assert  isRed(h.right);

        Node x = h.right;
        h.right = x.left;
        x.color = h.color;
        x.left = h;
        h.color = RED;

        return x;
    }

    private Node rotateRight(Node h) {
        assert  isRed(h.left);

        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;

        return x;
    }

    // when both the links coming out of a node are red. Temporary 4-node
    private void flipColors(Node h) {
        assert isRed(h.left);
        assert isRed(h.right);
        assert !isRed(h);

        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;

    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }
}
