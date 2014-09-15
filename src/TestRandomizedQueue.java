import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * RandomizedQueue Unit Tests for Coursera Algs4
 * 
 * -----------------------------------------------------------------------
 * 
 * NOTICE: These tests are INCOMPLETE. They only test the API and
 * exceptions required by the specification.
 * 
 * You must download DequeAPI.java and place it in your project folder.
 * @see <a href="https://raw.githubusercontent.com/alwarren/algs4/master/DequeAPI.java">DequeAPI.java</a>
 * 
 * You must download APIChecker.java and place it in your project folder.
 * @see <a href="http://algs4.cs.princeton.edu/code/APIChecker.java">APIChecker.java</a>
 * 
 * -----------------------------------------------------------------------
 * 
 * @author Al Warren
 * @version 0.1, 2014-09-15
 *
 */

public class TestRandomizedQueue {

    /**
     * -----------------------------------------------------------------------
     * Test API 
     * -----------------------------------------------------------------------
     */
    @Test
    public void testAPI() throws Exception {
        String name = "RandomizedQueue";
        boolean b = false;
        try {
            Class<?> c = Class.forName(name);
            b = true;
            Class<?> refC = Class.forName(name + "API");

            APIChecker checker = new APIChecker(c, refC, name, name + "API");
            assertEquals(true, APIChecker.checkAll(checker, true));
        }
        catch (ClassNotFoundException x) {
            System.out.println(name + ":");
            System.out.print("Error: The class file for " + name);
            if (b)
                System.out.print("API");
            System.out.println(" could not be found.");
            throw new Exception();
        }
    }

    /**
     * ------------------------------------------------------------------------
     * Throw a NullPointerException if the client attempts to add a null item; 
     * ------------------------------------------------------------------------
     */
    @Test(expected = NullPointerException.class)
    public void testAddNullItem() throws Exception {
        RandomizedQueue<Object> q = new RandomizedQueue<Object>();
        q.enqueue(null);
    }
    
    /**
     * ------------------------------------------------------------------------
     * Throw a java.util.NoSuchElementException if the client attempts to 
     * sample or dequeue an item from an empty randomized queue; 
     * ------------------------------------------------------------------------
     */
    @Test(expected = NoSuchElementException.class)
    public void testDequeueFromEmptyQueue() throws Exception {
        RandomizedQueue<Object> q = new RandomizedQueue<Object>();
        q.dequeue();
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testSampleFromEmptyQueue() throws Exception {
        RandomizedQueue<Object> q = new RandomizedQueue<Object>();
        q.sample();
    }
    
    /**
     * ------------------------------------------------------------------------
     * Throw an UnsupportedOperationException if the client calls the remove() 
     * method in the iterator; 
     * ------------------------------------------------------------------------
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveInIterator() throws Exception {
        RandomizedQueue<Object> q = new RandomizedQueue<Object>();
        Iterator<Object> iter = q.iterator();
        iter.remove();
    }
    
    /**
     * ------------------------------------------------------------------------
     * Throw a java.util.NoSuchElementException if the client calls the next() 
     * method in the iterator and there are no more items to return. 
     * ------------------------------------------------------------------------
     */
    @Test(expected = NoSuchElementException.class)
    public void testNextWithNoNext() throws Exception {
        RandomizedQueue<Object> q = new RandomizedQueue<Object>();
        Iterator<Object> iter = q.iterator();
        iter.next();
    }
    
    /**
    @Test
    public void template() throws Exception {
        RandomizedQueue<Object> q = new RandomizedQueue<Object>();
    }
    
     */
}
