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


import java.util.Objects;

/**
 * An instance of Name holds a Baby's name
 *
 * @author William Barkoff
 */
public class Name {
    private String name;
    private int count;

    /**
     * Generates a new name
     * @param name
     * @param count
     */
    public Name(String name, int count) {
        this.name = name;
        this.count = count;
    }

    /**
     * Increments the count by a specified amount
     * @param count
     */
    public void addAmount(int count) {
        this.count += count;
    }

    /**
     * Returns the name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the count
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the count
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Name{");
        sb.append("name='").append(name).append('\'');
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return getCount() == name1.getCount() &&
                Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCount());
    }
}
