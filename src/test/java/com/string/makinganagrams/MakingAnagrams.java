package com.string.makinganagrams;





import org.junit.Assert;
import org.junit.Test;

public class MakingAnagrams {
    @Test
    public void findNumberDeletions(){
        int result = Result.makeAnagram("cde", "dfc");
        Assert.assertEquals(2, result);
    }
    @Test
    public void findNumberDeletions2(){
        int result = Result.makeAnagram("cde", "abc");
        Assert.assertEquals(4, result);
    }



}
