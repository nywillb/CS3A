package ICA.TimingArrayList.Tests;

import ICA.TimingArrayList.Test;

import java.util.ArrayList;

public class MinimumTest implements Test {
    public String getName() { return "maximum"; }

    public void runTest(ArrayList<Integer> list, int count) {
        int minimumValue = Integer.MAX_VALUE;
        int minimumIndex;
        for (int i = 0; i < count; i++) {
            if(list.get(i) < minimumValue) {
                minimumValue = list.get(i);
                minimumIndex = i;
            }
        }
    }
}
