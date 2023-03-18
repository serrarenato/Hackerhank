package com.hashmaps.countTriplets;




import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CountTriplets {
    @Test
    public void countTriplets1(){
        List<Long> data= Arrays.asList(1l,2l,2l,4l);
        long result = Solution.countTriplets(data,2);
        Assert.assertEquals(2,result);
    }
    @Test
    public void countTriplets2(){
        List<Long> data= Arrays.asList(1l,3l,9l,9l,27l,81l);
        long result = Solution.countTriplets(data,3);
        Assert.assertEquals(6, result);
    }


}
