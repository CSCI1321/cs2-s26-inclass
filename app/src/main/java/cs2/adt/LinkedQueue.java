package cs2.adt;

import java.util.NoSuchElementException;

public class LinkedQueue<T> extends Queue<T> {
    private class Node {
        public T data;
        public Node next;
        public Node(T d, Node n) {
            data = d; next = n;
        }
    }

    private Node head, last;

    public LinkedQueue() {
        head = null; last = null;
    }

    public void enqueue(T item) {
        if(last == null) {
            head = new Node(item, null);
            last = head;
        } else {
            last.next = new Node(item, null);
            last = last.next;
        }
    }
    public T dequeue() {
        if(isEmpty()) throw new NoSuchElementException();
        T tmp = head.data;
        if(head == last) {
            head = null;
            last = null;
        } else {
            head = head.next;
        }
        return tmp;
    }
    public T peek() {
        if(isEmpty()) throw new NoSuchElementException();
        return head.data;
    }
    public boolean isEmpty() {
        return head == null && last == null;
    }



}
