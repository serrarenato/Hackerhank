package com.string.alternatingcharacters;





import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AlternatingCharacters {
    @Test
    public void findNumberDeletionsRepeat(){
        int result = Result.alternatingCharacters("BBBBB");
        Assert.assertEquals(4, result);
    }
    @Test
    public void findNumberDeletionsRepeat2(){
        int result = Result.alternatingCharacters("AAAA");
        Assert.assertEquals(3, result);
    }
    @Test
    public void findNumberDeletions(){
        int result = Result.alternatingCharacters("AABAAB");
        Assert.assertEquals(2, result);
    }


}
