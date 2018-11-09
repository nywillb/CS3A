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

public class DoublyLinkedList<T> {
    private int length;
    private Node first;
    private Node last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.length = 0;
    }

    public void add(T value) {
        Node n = new Node(value, this.last);
        if(this.first == null) this.first = n;
        else this.last.setNext(n);
        this.last = n;
        this.length++;
    }

    public void remove(T value) throws NotInListException {
        remove(value, this.first);
    }

    private void remove(T value, Node n) throws NotInListException {
        if(n.getValue().equals(value)) {
            n.getPrevious().setNext(n.getNext());
            n.getNext().setPrevious(n.getPrevious());
        } else if(n.getNext() != null) {
            remove(value, n.getNext());
        } else {
            throw new NotInListException("Value " + value.toString() + " not in list");
        }
    }

    public boolean contains(T value) {
        return contains(value, this.first);
    }

    private boolean contains(T value, Node n) {
        if(n.getValue().equals(value)) {
            return true;
        } else if(n.getNext() != null) {
            return contains(value, n.getNext());
        } else {
            return false;
        }
    }
    
    public T get(int i) throws NotInListException {
        if(i < length/2 && i >= 0) {
            Node n = this.first;
            for (int j = 0; j < i; j++) {
                n = n.getNext();
            }
            return n.getValue();
        } else if (i >= length/2 && i < length) {
            Node n = this.last;
            for (int j = length; j > i; j--) {
                n = n.getPrevious();
            }
            return n.getValue();
        } else {
            throw new NotInListException("Cannot get element " + i + " of list length " + this.length);
        }
    }

    public int getLength() {
        return length;
    }


    private class Node {
        private T value;
        private Node next;
        private Node previous;

        public Node(T value, Node previous) {
            this.value = value;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
}
