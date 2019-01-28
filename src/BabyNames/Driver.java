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

public class Driver {
    public static void main(String[] args) {
        Name[] names = {
                new Name("ab", 5),
                new Name("abc", 10),
                new Name("acd", 20),
                new Name("zab", 15),
                new Name("xyz", 48)
        };

        AlphebeticalNameSearchTree a = new AlphebeticalNameSearchTree();

        for (Name name : names) {
            a.add(name);
        }

        Name[] results = a.search("a");
        for (Name name : results) {
            System.out.println(name.toString());
        }
    }
}
