package cs2.adt;

public abstract class List<T> {
    public abstract void set(int idx, T item);
    public abstract T get(int idx);
    public abstract void insert(int idx, T item);
    public abstract void remove(int idx);
}
