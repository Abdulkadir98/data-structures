package symboltable.bst;

import queue.dynamicarray.QueueDynamicArray;

import java.util.Queue;

public class BST<Key extends Comparable<Key>, Val> {

    private Node root;

    private class Node {

        Key key;
        Val val;
        Node left;
        Node right;
        int count;

        public Node(Key key, Val val, int count){
            this.key = key;
            this.val = val;
            this.count = count;
        }
    }

    public boolean isEmpty() {
        return size()  == 0;
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("contains() cannot be passed a null argument");
        return get(key) != null;
    }

    public Val get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public void put(Key key, Val val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Val val) {

        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);

        else if (cmp > 0)
            x.right = put(x.right, key, val);

        else
            x.val = val;

        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {

        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if ( cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {

            if (x.left == null) return x.right;
            if (x.right == null) return x.left;

            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
       else
           return min(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Iterable<Key> keys() {

        QueueDynamicArray<Key> q = new QueueDynamicArray<>();
        inorder(root, q);
        return q;
    }

    //inorder traversal of binary search tree
    private void inorder(Node x, QueueDynamicArray<Key> q) {
        if (x == null) return;
        inorder(x.left, q);
        q.enQueue(x.key);
        inorder(x.right, q);
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.count;
    }
}
