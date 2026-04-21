package cs2.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Comprehensive JUnit 5 tests for the List abstract data type.
 *
 * Test categories:
 *   1. Bounds checks      - invalid indexes should throw
 *   2. get()/set()        - read/write at valid indexes
 *   3. insert() behavior  - inserts at front/middle/end and shifts elements
 *   4. remove() behavior  - removes at front/middle/end and closes gaps
 *   5. Interleaved ops    - mixed operations preserve list contents
 */
public class ListTester {

    private List<Integer> list;

    @BeforeEach
    void init() {
        list = new LinkedList<Integer>();
    }

    // -----------------------------------------------------------------------
    // 1. Bounds checks
    // -----------------------------------------------------------------------

    @Test
    void testGetOnEmptyThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testSetOnEmptyThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 99));
    }

    @Test
    void testInsertInvalidIndexThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(-1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.insert(1, 10));
    }

    @Test
    void testRemoveOnEmptyThrows() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    // -----------------------------------------------------------------------
    // 2. get()/set()
    // -----------------------------------------------------------------------

    @Test
    void testSetThenGetSingleElement() {
        list.insert(0, 10);
        assertEquals(10, list.get(0));

        list.set(0, 42);
        assertEquals(42, list.get(0));
    }

    @Test
    void testGetSetAtMiddleIndex() {
        seed(10, 20, 30, 40, 50);
        assertEquals(30, list.get(2));

        list.set(2, 99);
        assertEquals(99, list.get(2));

        // neighboring elements should stay unchanged
        assertEquals(20, list.get(1));
        assertEquals(40, list.get(3));
    }

    @Test
    void testGetPastEndThrows() {
        seed(1, 2, 3);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    // -----------------------------------------------------------------------
    // 3. insert() behavior
    // -----------------------------------------------------------------------

    @Test
    void testInsertAtFrontShiftsRight() {
        seed(20, 30, 40);

        list.insert(0, 10);
        assertListEquals(10, 20, 30, 40);
    }

    @Test
    void testInsertInMiddleShiftsRight() {
        seed(10, 20, 40, 50);

        list.insert(2, 30);
        assertListEquals(10, 20, 30, 40, 50);
    }

    @Test
    void testInsertAtEndAppends() {
        seed(10, 20, 30);

        list.insert(3, 40);
        assertListEquals(10, 20, 30, 40);
    }

    // -----------------------------------------------------------------------
    // 4. remove() behavior
    // -----------------------------------------------------------------------

    @Test
    void testRemoveAtFrontShiftsLeft() {
        seed(10, 20, 30, 40);

        list.remove(0);
        assertListEquals(20, 30, 40);
    }

    @Test
    void testRemoveInMiddleClosesGap() {
        seed(10, 20, 30, 40, 50);

        list.remove(2);
        assertListEquals(10, 20, 40, 50);
    }

    @Test
    void testRemoveAtEnd() {
        seed(10, 20, 30);

        list.remove(2);
        assertListEquals(10, 20);
    }

    // -----------------------------------------------------------------------
    // 5. Interleaved operations
    // -----------------------------------------------------------------------

    @Test
    void testInterleavedOperations() {
        list.insert(0, 10); // [10]
        assertListEquals(10);

        list.insert(1, 30); // [10, 30]
        assertListEquals(10, 30);

        list.insert(1, 20); // [10, 20, 30]
        assertListEquals(10, 20, 30);

        list.set(2, 99);    // [10, 20, 99]
        assertListEquals(10, 20, 99);

        list.remove(1);     // [10, 99]
        assertListEquals(10, 99);

        list.insert(1, 50); // [10, 50, 99]
        assertListEquals(10, 50, 99);

        list.insert(3, 70); // [10, 50, 99, 70]
        assertListEquals(10, 50, 99, 70);

        list.remove(0);     // [50, 99, 70]
        assertListEquals(50, 99, 70);
    }

    private void seed(Integer... items) {
        for (int i = 0; i < items.length; i++) {
            list.insert(i, items[i]);
        }
    }

    private void assertListEquals(Integer... expected) {
        for (int i = 0; i < expected.length; i++) {
                        assertEquals(expected[i], list.get(i));
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(expected.length));
    }
}