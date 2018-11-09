package ICA.TimingArrayList.Tests;

import ICA.TimingArrayList.Test;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffleTest implements Test {
    public String getName() { return "Shuffle"; }

    public void runTest(ArrayList<Integer> list, int count) {
        Collections.shuffle(list);
    }
}
