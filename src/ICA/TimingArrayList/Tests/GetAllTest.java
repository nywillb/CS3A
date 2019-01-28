package ICA.TimingArrayList.Tests;

import ICA.TimingArrayList.Test;

import java.util.ArrayList;

public class GetAllTest implements Test {
    public String getName() { return "Get All"; }

    public void runTest(ArrayList<Integer> list, int count){
        for (int i = 0; i < count; i++) {
            list.get(i);
        }
    }
}
