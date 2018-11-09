package ICA.TimingArrayList.Tests;

import ICA.TimingArrayList.Test;

import java.util.ArrayList;

public class MaximumTest implements Test {
    public String getName() { return "maximum"; }

    public void runTest(ArrayList<Integer> list, int count) {
        int biggestValue = 0;
        int biggestIndex;
        for (int i = 0; i < count; i++) {
            if(list.get(i) > biggestValue) {
                biggestValue = list.get(i);
                biggestIndex = i;
            }
        }
    }
}
