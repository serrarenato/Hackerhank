package com.arrays.leftrotation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LeftRotation {
    @Test
    public void successLeftRotate(){
        List<Integer> data =  Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = Result.rotLeft(data,4);

        Assert.assertTrue("Wrong", result.equals(Arrays.asList(5,1,2,3,4)));
    }
    @Test
    public void successLeftRotate2(){
        List<Integer> data =  Arrays.asList(41, 73 ,89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58 ,1 ,86, 58, 26, 10, 86, 51);
        List<Integer> result = Result.rotLeft(data,10);

        Assert.assertTrue("Wrong", result.equals(Arrays.asList(5,1,2,3,4)));
    }
}
