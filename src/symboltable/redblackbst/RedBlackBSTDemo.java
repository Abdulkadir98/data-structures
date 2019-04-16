package symboltable.redblackbst;

public class RedBlackBSTDemo {

    public static void main(String[] args) {

        RedBlackBST<String, Integer> bst = new RedBlackBST<>();

        bst.put("E", 5);
        bst.put("F", 6);
        bst.put("C", 3);
        bst.put("D", 1);
        bst.put("A", 1);
        bst.put("B", 2);

        for (String key: bst.keys()) {
            System.out.println(key);
        }
    }
}
