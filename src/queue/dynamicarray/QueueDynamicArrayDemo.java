package queue.dynamicarray;

public class QueueDynamicArrayDemo {
    public static void main(String[] args) {

        QueueDynamicArray<String> q = new QueueDynamicArray<>();
        q.enQueue("Hello");
        q.enQueue("World!");

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());


//        for (String s: q) {
//            System.out.println(s);
//        }
    }
}
