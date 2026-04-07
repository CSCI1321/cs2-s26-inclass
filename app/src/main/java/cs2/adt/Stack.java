package cs2.adt;

import java.util.EmptyStackException;

public abstract class Stack<T> {
    public abstract void push(T item);
    public abstract T pop() throws EmptyStackException;
    public abstract T peek() throws EmptyStackException;
    public abstract boolean isEmpty();
}
