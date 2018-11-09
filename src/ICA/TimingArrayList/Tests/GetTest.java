package ICA.TimingArrayList.Tests;

import ICA.TimingArrayList.Test;

import java.util.ArrayList;

public class GetTest implements Test {
    public String getName() { return "Remove"; }

    public void runTest(ArrayList<Integer> list, int count) {
        list.get(count-1);
    }
}
