package joshuaburt_sec005_ex03;

public class DataQueueTest {
    public static void main(String[] args) {

        // Queue of Strings
        DataQueue<String> stringQueue = new DataQueue<>();
        stringQueue.enqueue("Magnetic");
        stringQueue.enqueue("Hmaia");
        stringQueue.enqueue("Zinc");
        stringQueue.enqueue("Aggelos");
        stringQueue.dequeue(); //removes first queued stringQueue object
        stringQueue.enqueue("Copper");
        stringQueue.enqueue("Maria");
        stringQueue.enqueue("Magnetic");
        stringQueue.print(); //prints the enqueued stringQueue objects
        System.out.println();

        // Queue of Stock values (double)
        DataQueue<Double> stockQueue = new DataQueue<>();

        stockQueue.enqueue(6.12);
        stockQueue.enqueue(6.0);
        stockQueue.enqueue(30.12);
        stockQueue.enqueue(3.12);
        stockQueue.dequeue(); //removes first queued stockQueue object
        stockQueue.enqueue(9.21);
        stockQueue.enqueue(1.92);
        stockQueue.enqueue(6.12);
        stockQueue.print(); //prints the enqueued stockQueue objects
        System.out.println();
    }
}