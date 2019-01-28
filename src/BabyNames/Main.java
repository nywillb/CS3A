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

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        Reader dataFile = new FileReader("resources/BabyNames/babynames.csv");

        ArrayList<Name> names = new ArrayList<>();
        HashMap<String, Integer> fnames = new HashMap<>();

        Iterable<CSVRecord> rows = CSVFormat.EXCEL.withHeader().parse(dataFile);

        for(CSVRecord row : rows) {
            String fname = row.get("Child's First Name").toLowerCase();
            int number = Integer.parseInt(row.get("Count"));

            if(fnames.containsKey(fname)) {
                names.get(fnames.get(fname)).addAmount(number);
                continue;
            }

            fnames.put(fname, fnames.size());
            names.add(new Name(fname, number));

            Name name = new Name(fname, number);
        }

        AlphebeticalNameSearchTree tree = new AlphebeticalNameSearchTree();

        for (Name name : names) {
            tree.add(name);
        }

        System.out.println("Results");

        long start = System.currentTimeMillis();
        Name[] results = tree.search("han");
        long end = System.currentTimeMillis();

        System.out.printf("Found %d matches in %dms\n", results.length, end-start);

        for (Name name : results) {
            System.out.println(name.toString());
        }

    }
}
