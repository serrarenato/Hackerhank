package com.hashmaps.kidnapper;

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

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {// O(n) Constant
        Map<String, Integer> words = new HashMap<>();
        for (String word : magazine) {
            Integer value = words.get(word);
            if (null == value) {
                words.put(word, 1);
            } else {
                words.put(word, value + 1);
            }
        }
        for (String word : note) {
            if (words.containsKey(word)) {
                if (words.get(word) == 1) {
                    words.remove(word);
                } else {
                    words.put(word, words.get(word) - 1);
                }
            } else {
                System.out.println("No");
                return;
            }

        }
       // System.out.println(words.toString());


        System.out.println("Yes");


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}

