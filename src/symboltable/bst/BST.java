package symboltable.bst;

public class BST<Key extends Comparable<Key>, Val> {

    private Node root;

    private class Node {

        Key key;
        Val val;
        Node left;
        Node right;

        public Node(Key key, Val val){
            this.key = key;
            this.val = val;
        }
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

        if (x == null) return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);

        else if (cmp > 0)
            x.right = put(x.right, key, val);

        else
            x.val = val;

        return x;
    }
}
