package cs2.adt;

import java.util.NoSuchElementException;

public class ArrayQueue<T> extends Queue<T> {
    private T[] arr;
    private int len, beg;

    public ArrayQueue() {
        arr = (T[]) new Object[10];
        len = 0;
        beg = 0;
    }

    public void enqueue(T item) {
        if(len == arr.length) {
            T[] tmp = (T[]) new Object[len * 2];
            for(int i=0; i<len; i++) {
                tmp[i] = arr[(beg+i)%arr.length];
            }
            arr = tmp;
            beg = 0;
        }
        arr[(beg + len) % arr.length] = item;
        len += 1;
    }
    public T dequeue() {
        if(isEmpty()) throw new NoSuchElementException();
        T ret = arr[beg];
        beg = (beg + 1) % arr.length;
        len -= 1;
        return ret;
    }
    public T peek() { 
        if(isEmpty()) throw new NoSuchElementException();
        return arr[beg];
    }
    public boolean isEmpty() { return len == 0; }
    
}
