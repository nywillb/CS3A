/*
 * Copyright (c) 2019 William Barkoff, William Ricci, Hannah Levin.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package BabyNames;

import java.util.LinkedList;

public class AlphebeticalNameSearchTree {
    private Node[] topLevel;

    public AlphebeticalNameSearchTree() {
        this.topLevel = new Node[26];
        for (int i = 0; i < topLevel.length; i++) {
            this.topLevel[i] = new Node(null);
        }
    }

    public void add(Name n) {
        int index = getLetterNumber(n, 0);
        if(topLevel[index] == null) {
            topLevel[index] = new Node(n);
        }
        topLevel[index].trickleDown(n, 1);
    }

    public Name[] search(String s) {
        Node n = this.topLevel[getLetterNumber(s.toCharArray()[0])];
        char[] letters = s.toCharArray();
        try {
            for (int i = 1; i < letters.length; i++) {
                n = n.children[getLetterNumber(s.charAt(i))];
            }
        } catch (NullPointerException e) {
            return new Name[0];
        }
        if (n == null) return new Name[0];

        LinkedList<Name> l = new LinkedList<>();
        n.traverse(l);
        Name[] results = new Name[l.size()];
        l.toArray(results);
        return results;
    }

    private class Node {
        Node[] children;
        Name data;

        public Node(Name data) {
            this.data = data;
            this.children = new Node[26];
        }

        public void trickleDown(Name n, int number) {
            int index = getLetterNumber(n, number);
            if (number == n.getName().length()-1) {
                if(children[index] == null) {
                    children[index] = new Node(null);
                }
                children[index].setData(n);
            } else {
                if(children[index] == null) {
                    children[index] = new Node(null);
                }
                children[index].trickleDown(n, number+1);
            }
        }

        public void traverse(LinkedList<Name> l) {
            if(this.data != null) {
                l.add(this.data);
            }
            for(Node child : children) {
                try {
                    child.traverse(l);
                } catch (NullPointerException e) {

                }
            }
        }

        public Name getData() {
            return data;
        }

        public void setData(Name data) {
            this.data = data;
        }
    }

    private static int getLetterNumber(Name n, int position) {
        char c = n.getName().charAt(position);
        if (c < 91) {
            return c - 64;
        }
        return c - 97;
    }

    private static int getLetterNumber(char c) {
        if (c < 91) {
            return c - 64;
        }
        return c - 97;
    }
}
