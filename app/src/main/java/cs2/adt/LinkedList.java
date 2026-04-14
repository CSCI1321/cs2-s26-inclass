package cs2.adt;

public class LinkedList<T> extends List<T> {
    private class Node {
        public T data;
        public Node prev, next;
        public Node(T d, Node p, Node n) {
            data = d; prev = p; next = n;
        }
    }
    
    private Node head, last;

    public LinkedList() {
        head = null;
        last = null;
    }

    public T get(int idx) {
        Node rover = head;
        for(int i=0; i<idx; i++) {
            rover = rover.next;
        }
        return rover.data;
    }
    public void set(int idx, T item) {
        Node rover = head;
        for(int i=0; i<idx; i++) {
            rover = rover.next;
        }
        rover.data = item;
    }
    public void insert(int idx, T item) {
        Node rover = head;
        for(int i=0; i<idx-1; i++) {
            rover = rover.next;
        }
        rover.next = new Node(item, rover, rover.next);
        rover.next.next.prev = rover.next;
    }
    public void remove(int idx) {
        Node rover = head;
        for(int i=0; i<idx; i++) {
            rover = rover.next;
        }
        rover.prev.next = rover.next;
        rover.next.prev = rover.prev;
    }



}
