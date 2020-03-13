import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue {

    private int id;
    private LinkedList<Object> queue = new LinkedList<>();

    public Queue(int id){
        this.id = id;
    }

    // Add an item to back of queue.
    public void enqueue(Object obj) {
        queue.addLast(obj);
    }

    // Remove the next item from the front of the queue.
    // (Note that queue.removeFirst() both removes an
    // item from the list, and returns the item that
    // was removed.) Throws a NoSuchElementException
    // if there are no items on the queue.
    public Object dequeue() {
        return queue.removeFirst();
    }

    // Test if the queue is empty.
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Returns the size of the LinkedList
    public int size(){
        return queue.size();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return String.valueOf(this.queue);
    }
}
