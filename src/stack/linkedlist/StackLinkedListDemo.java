package stack.linkedlist;


public class StackLinkedListDemo {

    public static void main(String[] args) {

        StackLinkedList<String> st = new StackLinkedList<>();

        st.push("Hello");
        st.push("World!");

        for (String s: st){
            System.out.println(s);
        }
    }
}