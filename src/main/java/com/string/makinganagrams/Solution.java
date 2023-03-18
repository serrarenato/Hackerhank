package com.string.makinganagrams;

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
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {

        Map<String, Integer> copyA = new HashMap<>();
        Map<String, Integer> copyB = new HashMap<>();
        int numberDeletions = 0;
        for (Character ch : a.toCharArray()) {
            copyA.put(ch.toString(), copyA.getOrDefault(ch.toString(), 0) + 1);
        }
        for (Character ch : b.toCharArray()) {
            copyB.put(ch.toString(), copyB.getOrDefault(ch.toString(), 0) + 1);
        }
        for (Character ch : a.toCharArray()) {
            if (copyB.containsKey(ch.toString())) {
                if (copyB.get(ch.toString()) > 0) {
                    copyB.put(ch.toString(), copyB.getOrDefault(ch.toString(), 0) - 1);
                    continue;
                }
            }
            numberDeletions++;
        }
        for (Character ch : b.toCharArray()) {
            if (copyA.containsKey(ch.toString())) {
                if (copyA.get(ch.toString()) > 0) {
                    copyA.put(ch.toString(), copyA.getOrDefault(ch.toString(), 0) - 1);
                    continue;
                }
            }
            numberDeletions++;
        }
        return numberDeletions;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
