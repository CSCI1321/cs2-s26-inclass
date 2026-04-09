package cs2.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive JUnit 5 tests for the Queue abstract data type.
 *
 * Test categories:
 *   1. isEmpty()          – empty/non-empty state
 *   2. peek()             – returns front without removing; throws on empty
 *   3. dequeue()          – removes and returns front; throws on empty
 *   4. FIFO ordering      – items come out in the same order they went in
 *   5. Interleaved ops    – mixing enqueue/dequeue preserves correctness
 *   6. Capacity growth    – queue still works after internal resizing
 */
public class QueueTester {

    private Queue<Integer> q;

    // -----------------------------------------------------------------------
    // Setup
    // -----------------------------------------------------------------------

    /**
     * Runs before every test method. Creates a fresh, empty queue so each
     * test starts from a known state and tests stay independent.
     */
    @BeforeEach
    void init() {
        q = new LinkedQueue<Integer>();
    }

    // -----------------------------------------------------------------------
    // 1. isEmpty()
    // -----------------------------------------------------------------------

    /** A brand-new queue must report itself as empty. */
    @Test
    void testNewQueueIsEmpty() {
        assertTrue(q.isEmpty());
    }

    /** Enqueueing one item must make the queue non-empty. */
    @Test
    void testEnqueueMakesNotEmpty() {
        q.enqueue(42);
        assertFalse(q.isEmpty());
    }

    /** After enqueueing and then dequeueing the only item, the queue is empty again. */
    @Test
    void testEmptyAfterEnqueueThenDequeue() {
        q.enqueue(42);
        q.dequeue();
        assertTrue(q.isEmpty());
    }

    // -----------------------------------------------------------------------
    // 2. peek()
    // -----------------------------------------------------------------------

    /** peek() must return the front element (the first one enqueued). */
    @Test
    void testPeekReturnsFront() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, q.peek());
    }

    /** Calling peek() must not remove the item — the queue stays non-empty. */
    @Test
    void testPeekDoesNotRemoveItem() {
        q.enqueue(7);
        assertEquals(7, q.peek()); // first call
        assertEquals(7, q.peek()); // second call — same result
        assertFalse(q.isEmpty());  // item is still present
    }

    /** peek() must stay correct after the front item changes via dequeue(). */
    @Test
    void testPeekUpdateAfterDequeue() {
        q.enqueue(10);
        q.enqueue(20);
        assertEquals(10, q.peek());
        q.dequeue();                // remove 10
        assertEquals(20, q.peek()); // 20 is now at the front
    }

    /** peek() on an empty queue must throw an exception. */
    @Test
    void testPeekEmptyQueueThrows() {
        assertThrows(NoSuchElementException.class, () -> q.peek());
    }

    // -----------------------------------------------------------------------
    // 3. dequeue()
    // -----------------------------------------------------------------------

    /** dequeue() must return the value of the front element. */
    @Test
    void testDequeueReturnsFrontValue() {
        q.enqueue(5);
        assertEquals(5, q.dequeue());
    }

    /** After dequeue() the returned item is gone from the queue. */
    @Test
    void testDequeueRemovesItem() {
        q.enqueue(5);
        q.dequeue();
        assertTrue(q.isEmpty());
    }

    /** dequeue() on an empty queue must throw an exception. */
    @Test
    void testDequeueEmptyQueueThrows() {
        assertThrows(NoSuchElementException.class, () -> q.dequeue());
    }

    /** dequeue() throws even after the queue becomes empty mid-use. */
    @Test
    void testDequeueThrowsAfterQueueDrained() {
        q.enqueue(1);
        q.dequeue();               // queue is now empty
        assertThrows(NoSuchElementException.class, () -> q.dequeue());
    }

    // -----------------------------------------------------------------------
    // 4. FIFO ordering
    // -----------------------------------------------------------------------

    /** Items must come out in First-In-First-Out order. */
    @Test
    void testFIFOOrderSmall() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1, q.dequeue());
        assertEquals(2, q.dequeue());
        assertEquals(3, q.dequeue());
        assertTrue(q.isEmpty());
    }

    /**
     * Enqueue 1 000 items then dequeue them all. Every item must come back
     * in the original order, and the queue must be empty at the end.
     */
    @Test
    void testFIFOOrderManyItems() {
        for (int i = 0; i < 1000; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < 1000; i++) {
            assertFalse(q.isEmpty());
            assertEquals(i, q.peek());    // front value is correct
            assertEquals(i, q.dequeue()); // dequeue returns same value
        }
        assertTrue(q.isEmpty());
    }

    // -----------------------------------------------------------------------
    // 5. Interleaved enqueue / dequeue operations
    // -----------------------------------------------------------------------

    /**
     * Real queues are used with interleaved enqueues and dequeues.
     * FIFO order must be maintained across these mixed operations.
     */
    @Test
    void testInterleavedEnqueueDequeue() {
        q.enqueue(10);
        q.enqueue(20);
        assertEquals(10, q.dequeue()); // remove 10

        q.enqueue(30);                 // add 30 after 20
        assertEquals(20, q.dequeue()); // 20 was enqueued before 30
        assertEquals(30, q.dequeue());
        assertTrue(q.isEmpty());
    }

    /** A queue that has been fully drained must work correctly when refilled. */
    @Test
    void testRefillAfterDrained() {
        q.enqueue(1);
        q.dequeue();
        assertTrue(q.isEmpty());

        // refill
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(2, q.dequeue());
        assertEquals(3, q.dequeue());
        assertTrue(q.isEmpty());
    }

    // -----------------------------------------------------------------------
    // 6. Capacity growth
    // -----------------------------------------------------------------------

    /**
     * ArrayQueue starts with a small internal array. Verify that FIFO ordering
     * and correctness are preserved after the array has been resized at least once.
     * (Default initial capacity is 10, so 11+ items trigger a resize.)
     */
    @Test
    void testCorrectAfterResize() {
        int n = 25; // forces at least two resizes from an initial capacity of 10
        for (int i = 0; i < n; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < n; i++) {
            assertEquals(i, q.dequeue());
        }
        assertTrue(q.isEmpty());
    }

    /**
     * Interleaved operations that cause the head pointer to wrap around the
     * circular buffer, then trigger a resize, must still yield correct FIFO order.
     */
    @Test
    void testResizeDuringWraparound() {
        // Fill and partially drain to advance the head pointer into the middle
        for (int i = 0; i < 8; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < 8; i++) {
            q.dequeue(); // head is now at index 8 in a capacity-10 array
        }

        // Re-fill past original capacity; internal head will be mid-array when resize fires
        for (int i = 0; i < 20; i++) {
            q.enqueue(i);
        }
        for (int i = 0; i < 20; i++) {
            assertEquals(i, q.dequeue());
        }
        assertTrue(q.isEmpty());
    }
}

