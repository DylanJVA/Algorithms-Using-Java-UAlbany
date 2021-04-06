/**
 * Queue class
 * Creates and implements a generic priority queue data structure
 * @author Dylan VanAllen
 */
import java.util.Comparator;
public class Queue<T> {
    private Heap<T> heap;
    /**
     * Queue constructor creates a new heap
     */
    public Queue() {
        heap = new Heap<T>();
    }
    /**
     * gets the heap stored in this queue
     * @return the heap
     */
    public Heap<T> getHeap() {
        return heap;
    }
    /**
     * inserts an item to the queue
     * @param item item to be added
     */
    public void insert(T item) {
        heap.insert(item);
    }
    /**
     * removed an item from the root of the queue
     * @return the removed item
     */
    public T delete() {
        return heap.delete();
    }
    /**
     * Checks if the queue is empty
     * @return true if it is empty false if not
     */
    public boolean isEmpty() {
        if (heap.isEmpty()) return true;
        else return false;
    }
    /**
     * Sorts the queue using the heapsort algorithm
     * @param c the comparator class used to compare the objects
     */
    public void sort(Comparator<T> c) {
        heap.sort(c);
    }


}