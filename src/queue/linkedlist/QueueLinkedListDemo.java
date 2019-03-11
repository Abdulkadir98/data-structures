package queue.linkedlist;

public class QueueLinkedListDemo {

    public static void main(String[] args) {

        QueueLinkedList<String> q = new QueueLinkedList<>();

        q.enQueue("Hello");
        q.enQueue("World");
        q.enQueue("bitch");
        q.enQueue("lasagna");

        q.deQueue();
        q.deQueue();
        q.deQueue();
        q.deQueue();

       System.out.println(q.isEmpty());



    }
}
