package symboltable.trie;

public class TrieST<Value> {

    private static final int R = 256;

    private static Node root = new Node();

    private static class Node {

        Object value;
        Node[] next = new Node[R];
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, String key, Value val, int d) {

        if (x == null) x = new Node();
        if (d == key.length()) {
            x.value = val;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.value;
    }

    private Node get(Node x, String key, int d) {

        if (x == null) return null;
        if (d == key.length()) return x;

        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    public boolean contains(String key) {

        return get(key) != null;
    }

    public static void main(String[] args) {

        TrieST<Integer> st = new TrieST();
        st.put("he", 1);
        st.put("shore", 2);

        System.out.println(st.get("shore"));
    }
}
