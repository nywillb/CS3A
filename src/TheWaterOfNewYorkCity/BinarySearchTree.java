package TheWaterOfNewYorkCity;

public class BinarySearchTree<T extends Comparable> {
    Node root;
    int size;

    public BinarySearchTree() {
        this.size = 0;
    }

    public void add(T data){
        if(data == null) throw new NullPointerException();
        Node n = new Node(data);
        size++;
        if(root == null) {
            root = n;
        } else {
            trickleDown(n, root);
        }
    }

    private void trickleDown(Node data, Node current) {
        boolean greaterThanCurrent = (data.value.compareTo(current) > 0);
        if(greaterThanCurrent && current.right == null){
            current.right = data;
        } else if(greaterThanCurrent) {
            trickleDown(data, current.right);
        } else if(current.left == null) {
            current.left = data;
        } else {
            trickleDown(data, current.left);
        }
    }

    //TODO: Implement remove

    public int length() {
        return size;
    }

    //TODO: Implement search


    private class Node {
        protected Node left;
        protected Node right;
        protected Node parent;
        protected T value;

        public Node(T value) {
            this.value = value;
        }
    }
}
