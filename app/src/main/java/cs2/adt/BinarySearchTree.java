package cs2.adt;

public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        public T data;
        public Node left, right;
        public Node(T d, Node l, Node r) {
            data = d; left = l; right = r;
        }
    }

    private Node root;

    public boolean contains(T item) {
        Node current = root;
        while(current.data.compareTo(item) != 0) {
            if(current.data.compareTo(item) < 0) {
                current = current.right;
            } else if(current.data.compareTo(item) > 0) {
                current = current.left;
            }
            if(current == null) return false;
        }
        return true;
    }

    public boolean contains(T item) {
        return containsRecur(item, root);
    }
    public boolean containsRecur(T item, Node curr) {
        if(curr == null) return false;
        if(curr.data.compareTo(item) == 0) return true;
        else {
            if(item.compareTo(curr.data) < 0) {
                return containsRecur(item, curr.left);
            } else {
                return containsRecur(item, curr.right);
            }
        }
    }


    public void insert(T item) {
        Node current = root;
        boolean done = false;
        if(root == null) {
            root = new Node(item, null, null);
            done = true;
        }
        while(!done) {
            if(current.data.compareTo(item) < 0) {
                if(current.right == null) {
                    current.right = new Node(item, null, null);
                    done = true;
                }
                current = current.right;
            } else if(current.data.compareTo(item) > 0) {
                if(current.left == null) {
                    current.left = new Node(item, null, null);
                    done = true;
                }
                current = current.left;
            }
        }
    }

    public void remove(T item) {
        Node curr = root;
        while(curr.data != item) {
            if(curr.data.compareTo(item) < 0) curr = curr.right;
            if(curr.data.compareTo(item) > 0) curr = curr.left;
        }

    }





    
}
