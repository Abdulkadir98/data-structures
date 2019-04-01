package symboltable.bst;

public class BSTDemo {

    public static void main(String[] args) {

        BST<String, Integer> bst = new BST<>();

        bst.put("A", 1);
        bst.put("B", 2);
        bst.put("C", 3);
        bst.put("D", 1);

        System.out.println(bst.get("D"));
    }
}
