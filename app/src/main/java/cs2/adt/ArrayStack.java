package cs2.adt;

import java.util.EmptyStackException;

public class ArrayStack<T> extends Stack<T> {
    private T[] arr;
    private int len;

    public ArrayStack() {
        arr = (T[])new Object[10];
        len = 0;
    }


    public void push(T item) {
        if(len == arr.length) {
            T[] tmp = (T[]) new Object[arr.length * 2];
            for(int i=0; i<arr.length; i++) {
                tmp[i] = arr[i];
            }
            arr = tmp;
        }
        arr[len] = item;
        len++;
    }
    public T pop() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        len--;
        return arr[len];
    }
    public T peek() throws EmptyStackException {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[len-1];
    }
    public boolean isEmpty() { return len == 0; }


    /*
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
    */
}
