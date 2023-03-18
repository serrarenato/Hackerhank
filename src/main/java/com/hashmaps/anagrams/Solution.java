package com.hashmaps.anagrams;

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

    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length(); i++) {
            for (int x = i + 1; x <= s.length(); x++) {
                String subStr = s.substring(i, x);
                char[] ch = subStr.toCharArray();
                Arrays.sort(ch);
                String c = new String(ch);

                if (map.containsKey(c)) {
                    map.put(c.toString(), map.get(c) + 1);
                } else {
                    map.put(c.toString(), 1);
                }
            }

        }
        int sum = 0;
        for (String word : map.keySet()) {
            if (map.get(word)!=1)
                sum+=map.get(word)*(map.get(word)-1)/2;
                //4*(4-1)->6
                // 3(3-1)->3 --
            // 3 -- 6
            // 2 -- 3
        }

        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
        return sum;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = Result.sherlockAndAnagrams(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
