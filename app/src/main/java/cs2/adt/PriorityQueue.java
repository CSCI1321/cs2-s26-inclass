package cs2.adt;

public abstract class PriorityQueue<T extends Comparable<T>> {
    public abstract void add(T item);
    public abstract T get();
    public abstract T peek();
    public abstract boolean isEmpty();
}
