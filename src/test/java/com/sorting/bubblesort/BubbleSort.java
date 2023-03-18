package com.sorting.bubblesort;




import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleSort {
    @Test
    public void success1(){
        Result.countSwaps(Arrays.asList(6,4,1));
//        Array is sorted in 3 swaps.
//            First Element: 1
//        Last Element: 6
    }
    public void success2(){
        Result.countSwaps(Arrays.asList(4, 2, 3, 1));
//        Array is sorted in 3 swaps.
//            First Element: 1
//        Last Element: 6
    }


}
