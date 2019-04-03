package symboltable.bst;

/**
 * Time complexity of ordered oerations: O(h) where h i height of tree (Average case)
 * if items come in order then the ordered operations take linear time
 *
 */
public class BSTDemo {

    public static void main(String[] args) {

        BST<String, Integer> bst = new BST<>();

        bst.put("E", 5);
        bst.put("F", 6);
        bst.put("C", 3);
        bst.put("D", 1);
        bst.put("A", 1);
        bst.put("B", 2);


        for (Comparable data: bst.keys()) {
            System.out.println(data);
        }

        //System.out.println(bst.contains("E"));

    }
}
