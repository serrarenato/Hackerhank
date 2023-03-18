package com.arrays.minimumswaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestQueue {
    @Test
    public void successCount() {
        int[] data =  {7, 1, 3, 2, 4, 5, 6};
        int result = Solution.minimumSwaps(data);
        Assert.assertEquals(result, 5);
    }
    @Test
    public void successCount2() {
        int[] data =  {4, 3, 1, 2};
        int result = Solution.minimumSwaps(data);
        Assert.assertEquals(result, 3);
    }
}
