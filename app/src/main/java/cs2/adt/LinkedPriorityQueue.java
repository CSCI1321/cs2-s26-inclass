package cs2.adt;

public  class LinkedPriorityQueue<T extends Comparable<T>> extends PriorityQueue<T> {
    private class Node {
        public T data;
        public Node next;
        public Node(T d, Node n) {
            data = d; next = n;
        }
    }

    private Node head;

    public LinkedPriorityQueue() {
        head = null;
    }

    public T peek() {
        return head.data;
    }
    public T get() {
        T tmp = head.data;
        head = head.next;
        return tmp;
    }
    public void add(T item) {
        if(item.compareTo(head.data) > 0) {
            head = new Node(item, head);
        } else {
            Node rover = head;
            while(rover.next != null && item.compareTo(rover.next.data) < 0) {
                rover = rover.next;
            }
            rover.next = new Node(item, rover.next);
        }
    }

    /*
    public void add(T item) {
        head = new Node(item, head);
    }
    public T get() {
        Node bigNode = head;
        Node obb = null;
        Node rover = head;
        while(rover.next != null) {
            if(rover.next.data.compareTo(bigNode.data) > 0) {
                bigNode = rover.next;
                obb = rover;
            }
            rover = rover.next;
        }
        obb.next = bigNode.next;
        return bigNode.data;
    }
    public T peek() {
        T big = head.data;
        Node rover = head;
        while(rover != null) {
            if(rover.data.compareTo(big) > 0) {
                big = rover.data;
            }
            rover = rover.next;
        }
    }
    */
    public boolean isEmpty() { return head == null; }

}
