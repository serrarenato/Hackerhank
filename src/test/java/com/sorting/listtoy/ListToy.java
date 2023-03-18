package com.sorting.listtoy;





import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ListToy {
    @Test
    public void findMaxItens(){
        int result = Result.maximumToys(Arrays.asList(1,2,3,4),7);
        Assert.assertEquals(3, result);
    }
    @Test
    public void findMaxItens2(){
        int result = Result.maximumToys(Arrays.asList(1,12,5,111,200,1000,10),50);
        Assert.assertEquals(4, result);
    }



}
