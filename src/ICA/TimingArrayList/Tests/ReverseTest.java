package ICA.TimingArrayList.Tests;

import ICA.TimingArrayList.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseTest implements Test {
    public String getName() { return "Reverse"; }

    public void runTest(ArrayList<Integer> list, int count) {
        Collections.reverse(list);
    }
}
