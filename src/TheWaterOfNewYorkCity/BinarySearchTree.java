/*
 * Copyright (c) 2018 williambarkoff.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package TheWaterOfNewYorkCity;

/**
 * This is a Binary Search Tree Package. It should work in theory,
 * but was never tested in practice. Therefore, it is not recommended
 * that you use this code.
 * @param <T>
 */
@Deprecated
public class BinarySearchTree<T extends Comparable> {
    private Node root;
    private int size;

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

    public boolean contains(T value) {
        return contains(value, root);
    }

    private boolean contains(T value, Node n) {
        if(n.value.equals(value)) {
            return true;
        } else if(n.value.compareTo(value) < 0){
            return n.left != null && contains(value, n.left);
        } else {
            return n.right != null && contains(value, n.right);
        }
    }


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
