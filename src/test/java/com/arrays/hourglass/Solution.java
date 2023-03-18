package com.arrays.hourglass;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution {

    @Test
    public void successTestSumHighest(){
        List<List<Integer>> data = data1();
        int result = Result.hourglassSum(data);
        assert(result==19);
    }
    private List<List<Integer>> data1(){
        List<List<Integer>> input1= Arrays.asList(
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 1, 0, 0, 0, 0),
                Arrays.asList(1, 1, 1, 0, 0, 0),
                Arrays.asList(0, 0, 2, 4, 4, 0),
                Arrays.asList(0, 0, 0, 2, 0, 0),
                Arrays.asList(0, 0, 1, 2, 4, 0)
        );
        return input1;

    }

}
