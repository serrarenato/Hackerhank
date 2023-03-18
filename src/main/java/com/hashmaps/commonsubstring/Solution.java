package com.hashmaps.commonsubstring;

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

    public static String twoStrings(String s1, String s2) {
        char[] syllables = s1.toCharArray();
        char[] syllables2 = s2.toCharArray();
        Map<Character,Integer> temp = new HashMap<>();
        for (int x = 0; x < syllables2.length; x++) {
            temp.put(syllables2[x],1);
        }
        for (int x = 0; x < syllables.length; x++) {
            char syllable = syllables[x];
            if (temp.containsKey(syllable)){
                return "YES";
            }

        }
        return "NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
