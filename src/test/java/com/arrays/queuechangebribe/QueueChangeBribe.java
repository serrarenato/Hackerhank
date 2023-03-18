package com.arrays.queuechangebribe;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class QueueChangeBribe {
    @Test
    public void successChange(){
        List<Integer> data =  Arrays.asList(2, 1, 5, 3, 4);
        Result.minimumBribes(data);
        // Result = 3;
    }
    @Test
    public void failChange(){
        List<Integer> data =  Arrays.asList(2, 5, 1, 3, 4);
        Result.minimumBribes(data);
        // Result = Too chaotic;
    }
    @Test
    public void successChange2(){
        List<Integer> data =  Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4);
        Result.minimumBribes(data);
        // Result = 7;
    }
//    1, 2, 5, 3, 7, 8, 6, 4
//
//    1, 2, 3, 5, 4, 6, 7, 8
//    1, 2, 5, 3, 4, 6, 7, 8
//    1, 2, 5, 3, 4, 7, 6, 8
//    1, 2, 5, 3, 7, 4, 6, 8
//    1, 2, 5, 3, 7, 4, 8, 6
//    1, 2, 5, 3, 7, 8, 4, 6
//    1, 2, 5, 3, 7, 8, 4, 6 ----
//    originalPosition -x => 5-7=-2

}
