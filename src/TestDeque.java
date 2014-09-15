import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Deque Unit Tests for Coursera Algs4
 * 
 * -----------------------------------------------------------------------
 * 
 * NOTICE: These tests may be incomplete
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
 * @version 1.0, 2014-09-15
 *
 */

public class TestDeque {

    /**
     * -----------------------------------------------------------------------
     * Test API 
     * -----------------------------------------------------------------------
     */
    @Test
    public void testAPI() throws Exception {
        String name = "Deque";
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
     * -----------------------------------------------------------------------
     * Throw a NullPointerException if the client attempts to add a null item; 
     * -----------------------------------------------------------------------
     */
    @Test(expected = NullPointerException.class)
    public void testAddFirstNull() throws Exception {
        new Deque<Object>().addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddLastNull() throws Exception {
        new Deque<Object>().addLast(null);
    }

    /**
     * -----------------------------------------------------------------------------------------------
     * Throw an UnsupportedOperationException if the client calls the remove() method in the iterator; 
     * -----------------------------------------------------------------------------------------------
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveInIterator() throws Exception {
        Deque<Object> q = new Deque<Object>();
        q.addFirst(1);
        Iterator<Object> iter = q.iterator();
        iter.remove();
    }
    
    /**
     * -----------------------------------------------------------------------------------------------
     * Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator 
     * and there are no more items to return.  
     * -----------------------------------------------------------------------------------------------
     */
    @Test(expected = NoSuchElementException.class)
    public void testNextIterationWithNoNext() throws Exception {
        Deque<Object> q = new Deque<Object>();
        q.addFirst(1);
        Iterator<Object> iter = q.iterator();
        iter.next();
        iter.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testNextIterationWithNoNodes() throws Exception {
        Deque<Object> q = new Deque<Object>();
        Iterator<Object> iter = q.iterator();
        iter.next();
    }

    /**
     * -----------------------------------------------------------------------------------------------
     * Additional tests that are not required by the API  
     * -----------------------------------------------------------------------------------------------
     */
    @Test
    public void testIteratorHasNext() throws Exception {
        Deque<Object> q = new Deque<Object>();
        q.addFirst(0);
        Iterator<Object> iter = q.iterator();
        assertEquals(true, iter.hasNext());
    }

    @Test
    public void testAddFirst() throws Exception {
        Deque<Object> q = new Deque<Object>();
        q.addFirst(0);
        q.addFirst(1);
        Iterator<Object> iter = q.iterator();
        assertEquals(1, iter.next());
        assertEquals(0, iter.next());
    }

    @Test
    public void testAddLast() throws Exception {
        Deque<Object> q = new Deque<Object>();
        q.addLast(0);
        q.addLast(1);
        Iterator<Object> iter = q.iterator();
        assertEquals(0, iter.next());
        assertEquals(1, iter.next());
    }

    @Test
    public void removeFirst() throws Exception {
        Deque<Object> q = new Deque<Object>();
        q.addFirst(1);
        q.addFirst(0);
        q.removeFirst();
        Iterator<Object> iter = q.iterator();
        assertEquals(1, iter.next());
        assertEquals(false, iter.hasNext());
    }
    
    @Test
    public void removeLast() throws Exception {
        Deque<Object> q = new Deque<Object>();
        q.addFirst(0);
        q.addFirst(1);
        q.removeLast();
        Iterator<Object> iter = q.iterator();
        assertEquals(1, iter.next());
        assertEquals(false, iter.hasNext());
    }
    
    @Test
    public void testDequeSize() throws Exception {
        Deque<Object> q = new Deque<Object>();
        assertEquals(0, q.size());
        q.addFirst(0);
        q.addFirst(1);
        assertEquals(2, q.size());
    }
}
