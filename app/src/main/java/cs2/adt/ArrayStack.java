package cs2.adt;

public class ArrayStack<T> extends Stack<T> {
    private T[] arr;

    public ArrayStack() {
        arr = (T[])new Object[0];
    }

    public void push(T item) {
        T[] tmp = (T[])new Object[arr.length + 1];
        for(int i=0; i<arr.length; i++) {
            tmp[i] = arr[i];
        }
        tmp[arr.length] = item;
        arr = tmp;
    }
    public T pop() {
        T[] tmp = (T[]) new Object[arr.length - 1];
        for(int i=0; i<tmp.length; i++) {
            tmp[i] = arr[i];
        }
        T ret = arr[arr.length-1];
        arr = tmp;
        return ret;
    }
    public T peek() {
        return arr[arr.length - 1];
    }
    public boolean isEmpty() {
        return arr.length == 0;
    }
}
