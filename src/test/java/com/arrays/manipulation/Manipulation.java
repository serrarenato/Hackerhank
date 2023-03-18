package com.arrays.manipulation;

import com.arrays.minimumswaps.Solution;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Manipulation {
    @Test
    public void successManipulation() {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2, 100), Arrays.asList(2, 5, 100), Arrays.asList(3, 4, 100)
        );
        long result = Result.arrayManipulation(5, list);
        Assert.assertEquals(200L,result);
    }

}
