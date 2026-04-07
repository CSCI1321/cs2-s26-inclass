package cs2.adt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StackTester {
    private Stack<Integer> s;

    @BeforeEach
    void init() {
        s = new ArrayStack<Integer>();
    }

    @Test
    void testPushPop() {
        assertTrue(s.isEmpty());
        s.push(10);
        assertFalse(s.isEmpty());
        assertEquals(s.peek(), 10);
        assertEquals(s.pop(), 10);
        assertTrue(s.isEmpty());
    }

    @Test
    void testMultiPushPop() {
        assertTrue(s.isEmpty());
        for(int i=0; i<1000; i++) {
            s.push(i);
        }
        for(int i=999; i>=0; i--) {
            assertFalse(s.isEmpty());
            assertEquals(s.peek(), i);
            assertEquals(s.pop(), i);
        }
        assertTrue(s.isEmpty());
     }



    
}
