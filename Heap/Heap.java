/**
 * Heap class
 * Creates and implements a Heap data structure for use with a priority queue.
 * Requires a specified object E
 * @author Dylan VanAllen
 */
import java.util.ArrayList;
import java.util.Comparator;
public class Heap<E> {
    ArrayList<E> list;
    Comparator<E> comparator;

    //Creates a new heap with a new array list of type E
    public Heap() {
        this.list = new ArrayList<E>();
    }
    /**
     * gets the current heap
     * @return the heap
     */
    public ArrayList<E> getList() {
        return list;
    }
    /**
     * parent gets the parent node of this node
     * @param i index of the current node
     * @return index of parent node
     */
    public int parent(int i) {
        return i/2;
    }
    /**
     * left gets the left child node
     * @param i index of current node
     * @return index of left child
     */
    public int left(int i) {
        return 2*i;
    }
    /**
     * left gets the right child node
     * @param i index of current node
     * @return index of right child
     */
    public int right(int i) {
        return 2*i+1;
    }
    /**
     * Adds a new item to the heap
     * @param item element to be added
     */
    public void insert(E item) {
        list.add(item);
    }
    //Removes an item from the heap and returns it
    public E delete() {
        return list.remove(0);
    }
    //Checks if the current heap has no more members
    public boolean isEmpty() {
        if(list.size()==0) return true;
        else return false;
    }
    /**
     * sorts the heap by the specified comparator
     * @param comparator - tells the heap which field to sort by
     */
    public void sort(Comparator<E> comparator)
    {
        this.comparator = comparator;
        int n = list.size();
 
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(n, i);
 
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            E temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);
 
            // call heapify on the reduced heap
            heapify(i, 0);
        }
    }
    /**
     * Method to maintain heap structure
     * @param size - size of heap
     * @param i - index of current node
     */
    void heapify(int size, int i)
    {
        int max   = i; 
        int left  = left(i);
        int right = right(i);

        //if left child is larger than root
        if (left < size && comparator.compare(list.get(left),list.get(max)) < 0)
            max = left;

        // if right child is larger than max
        if (right < size && (comparator.compare(list.get(right),list.get(max)) < 0))
            max = right;

        // if max is not root
        if (max != i)
        {
            E temp = list.get(i);
            list.set(i, list.get(max));
            list.set(max, temp);

            // recursively heapify 
            heapify(size, max);
        }

    
    }

}