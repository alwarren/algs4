import java.util.Iterator;

public class DequeAPI<Item> implements Iterable<Item> {

    // construct an empty deque
    public DequeAPI() {}                                    

    // is the deque empty?
    public boolean isEmpty() { return  false; }

    // return the number of items on the deque
    public int size() { return 0; }
    
    // insert the item at the front
    public void addFirst(Item item) {}
    
    // insert the item at the end
    public void addLast(Item item) {}

    // delete and return the item at the front
    public Item removeFirst() { return null; }
    
    // delete and return the item at the end
    public Item removeLast() { return null; }
    
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() { return null; }

    // unit testing
    public static void main(String[] args) {}
    
}
