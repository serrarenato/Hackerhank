package com.string.validstring;





import org.junit.Assert;
import org.junit.Test;

public class ValidString {
    @Test
    public void isValidString(){
        String result = Result.isValid("abc");
        Assert.assertEquals("YES", result);
        //Yes
    }
    @Test
    public void isNotValidString(){
        String result = Result.isValid("aabbcd");
        Assert.assertEquals("NO", result);
        //No
    }
    @Test
    public void isNotValidString2(){
        String result = Result.isValid("abcdefghhgfedecba");
        Assert.assertEquals("YES", result);
        //No
    }



}
