package com.hashmaps.kidnapper;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Kidnapper {
    @Test
    public void successFindWords(){
        List<String> magazine =  Arrays.asList("give", "me", "one", "grand", "today", "night");
        List<String> note = Arrays.asList("give", "one", "grand", "today");
        Result.checkMagazine(magazine,note);
        // Yes
    }


}
