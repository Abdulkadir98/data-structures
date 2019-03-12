package queue.dynamicarray;

public class QueueDynamicArrayDemo {
    public static void main(String[] args) {

        QueueDynamicArray<String> q = new QueueDynamicArray<>();
        q.enQueue("Hello");
        q.enQueue("World!");


        for (String s: q) {
            System.out.println(s);
        }
    }
}
