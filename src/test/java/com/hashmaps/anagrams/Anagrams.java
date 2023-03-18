package com.hashmaps.anagrams;



import org.junit.Assert;
import org.junit.Test;

public class Anagrams {
    @Test
    public void successFindAnagrams(){
        String one = "abba";

        int result = Result.sherlockAndAnagrams(one);
        Assert.assertEquals(4, result);
    }
    @Test
    public void failFindAnagrams(){
        String one = "abcd";

        int result = Result.sherlockAndAnagrams(one);
        Assert.assertEquals(0, result);
    }
    @Test
    public void successFindAnagramsRepeated(){
        String one = "kkkk";

        int result = Result.sherlockAndAnagrams(one);
        Assert.assertEquals(10, result);
    }


}
