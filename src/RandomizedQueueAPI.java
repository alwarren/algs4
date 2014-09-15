import java.util.Iterator;

 public class RandomizedQueueAPI<Item> implements Iterable<Item> {
     // construct an empty randomized queue
     public RandomizedQueueAPI() {}
     // is the queue empty?
     public boolean isEmpty() { return true; }
     // return the number of items on the queue
     public int size() {return 0; }
     // add the item
     public void enqueue(Item item) {}
     // delete and return a random item
     public Item dequeue() { return null; }
     // return (but do not delete) a random item
     public Item sample() { return null; }
     // return an independent iterator over items in random order
     public Iterator<Item> iterator() { return null; }
     // unit testing
     public static void main(String[] args) {}
 }
