package com.string.validstring;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static String isValid(String s) {

        long amountTotal = 0;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Integer, Integer> listRepetead = new HashMap<>();
        /// letter/repeat a = 2 / b = 3 / c = 3
        for (Character ch : s.toCharArray()) {
            mapS.put(ch, mapS.getOrDefault(ch, 0) + 1);
        }
        // number repeat / repeat -- 2 = 1 / 3 = 2
        Integer maxNumberRepeat = Integer.MIN_VALUE;
        Integer minNumberRepeat = Integer.MAX_VALUE;
        for (Character ch : mapS.keySet()) {
            Integer value= mapS.get(ch);
            listRepetead.put(value, listRepetead.getOrDefault(value, 0) + 1);
            if (value>maxNumberRepeat)
                maxNumberRepeat=value;
            if (value<minNumberRepeat)
                minNumberRepeat=value;
        }

        if (listRepetead.size() == 1){
            return "YES";
        }
        if (listRepetead.size() > 2) {
            return "NO";
        } else if (listRepetead.size() == 2) {
            if (maxNumberRepeat-minNumberRepeat>1){
                return "NO";
            }
            Integer maxValue = Integer.MIN_VALUE;
            Integer minValue = Integer.MAX_VALUE;
            for (Integer count : listRepetead.keySet()) {
                if (listRepetead.get(count)>maxValue){
                    maxValue=listRepetead.get(count);
                }
                if (listRepetead.get(count)<minValue){
                    minValue=listRepetead.get(count);
                }
            }
            if (maxValue==1 || minValue==1){
                return "YES";
            }else {
                return "NO";
            }


        }
        return "YES";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

