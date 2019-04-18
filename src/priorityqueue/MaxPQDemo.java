package priorityqueue;

public class MaxPQDemo {

    public static void main(String[] args) {

        MinPQ<String> pq = new MinPQ<>(11);

        pq.insert("R");
        pq.insert("N");
        pq.insert("H");
        pq.insert("O");
        pq.insert("G");
        pq.insert("I");
        pq.insert("P");
        pq.insert("T");
        pq.insert("E");
        pq.insert("A");

//        for (Comparable item: pq) {
//            System.out.println(item);
//        }

        for (int i=0; i<10; i++)
            System.out.println(pq.delMin());
    }
}
