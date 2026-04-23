package cs2.adt;

public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        public T data;
        public Node left, right;
        public Node(T d, Node l, Node r) {
            data = d; left = l; right = r;
        }

        public boolean contains(T item) {
            if(this.data.compareTo(item) == 0) return true;
            else {
                if(item.compareTo(this.data) < 0) {
                    if(this.left != null) return this.left.contains(item);
                    else return false;
                } else {
                    if(this.right != null) return this.right.contains(item);
                    else return false;
                }
            }
        }

        public void insert(T item) {
            if(this.data.compareTo(item) < 0) {
                if(right == null) { right = new Node(item, null, null); }
                else right.insert(item);
            } else {
                if(left == null) { left = new Node(item, null, null); }
                else left.insert(item);
            }
        }

        public Node remove(T item) {
            if(this.data.compareTo(item) < 0) {
                right = right.remove(item);
                return this;
            } else if(this.data.compareTo(item) > 0) {
                left = left.remove(item);
                return this;
            } else {
                //No kids
                if(left == null) {
                    return right;
                } else if(right == null) {
                    return left;
                } else {
                    MaxResult res = left.passUpMax();
                    this.data = res.data;
                    left = res.kid;
                    return this;
                }
            }
        }

        private MaxResult passUpMax() {
            if(right == null) {
                return new MaxResult(this.data, left);
            } else {
                MaxResult res = right.passUpMax();
                right = res.kid;
                return new MaxResult(res.data, this);
            }
        }

        private class MaxResult {
            public T data;
            public Node kid;
            public MaxResult(T d, Node k) { data = d; kid = k; }
        }

    }

    private Node root;

    /*
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
    }*/
    public boolean contains(T item) {
        if(root == null) return false;
        return root.contains(item);
    }
    public void insert(T item) {
        if(root == null) root = new Node(item, null, null);
        else root.insert(item);
    }
    public void remove(T item) {
        if(root != null) { 
            root = root.remove(item);
        }
    }

    /*
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
    }*/

        
}
