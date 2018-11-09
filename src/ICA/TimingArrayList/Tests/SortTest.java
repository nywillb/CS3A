package ICA.TimingArrayList.Tests;

import ICA.TimingArrayList.Test;

import java.util.ArrayList;
import java.util.Collections;

public class SortTest implements Test {
    public String getName() { return "Sort"; }

    public void runTest(ArrayList<Integer> list, int count) {
        Collections.sort(list);
    }
}
