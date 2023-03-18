package com.hashmaps.commonsubstring;



import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CommonSubstring {
    @Test
    public void successFindSyllables(){
        String one = "hello";
        String two = "world";
        String result = Result.twoStrings(one,two);
        Assert.assertEquals("YES", result);
    }
    @Test
    public void failFindSyllables(){
        String one = "hi";
        String two = "world";
        String result = Result.twoStrings(one,two);
        Assert.assertEquals("NO", result);
    }


}
