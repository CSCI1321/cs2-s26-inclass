package cs2.adt;

public class LinkedList<T> extends List<T> {
    private class Node {
        public T data;
        public Node prev, next;
        public Node(T d, Node p, Node n) {
            data = d; prev = p; next = n;
        }
    }
    
    private Node end;
    private int size;

    public LinkedList() {
        end = new Node(null, end, end);
        end.prev = end;
        end.next = end;
        size = 0;
    }

    public T get(int idx) {
        if(idx < 0 || idx >= size) { throw new IndexOutOfBoundsException(); }
        Node rover = end.next;
        for(int i=0; i<idx; i++) {
            rover = rover.next;
        }
        return rover.data;
    }
    public void set(int idx, T item) {
        if(idx < 0 || idx >= size) { throw new IndexOutOfBoundsException(); }
        Node rover = end.next;
        for(int i=0; i<idx; i++) {
            rover = rover.next;
        }
        rover.data = item;
    }
    public void insert(int idx, T item) {
        if(idx < 0 || idx > size) { throw new IndexOutOfBoundsException(); }
        Node rover = end;
        for(int i=0; i<idx; i++) {
            rover = rover.next;
        }
        rover.next = new Node(item, rover, rover.next);
        rover.next.next.prev = rover.next;
        size++;
    }
    public void remove(int idx) {
        if(idx < 0 || idx >= size) { throw new IndexOutOfBoundsException(); }
        Node rover = end.next;
        for(int i=0; i<idx; i++) {
            rover = rover.next;
        }
        rover.prev.next = rover.next;
        rover.next.prev = rover.prev;
        size--;
    }



}
