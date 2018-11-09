package ICA.TimingArrayList.Tests;

import ICA.TimingArrayList.Test;

import java.util.ArrayList;

public class AddTest implements Test {
    public String getName() { return "Add"; }

    public void runTest(ArrayList<Integer> list, int count){
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
    }
}
