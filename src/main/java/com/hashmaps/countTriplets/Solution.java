package com.hashmaps.countTriplets;

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

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> numbersPossible = new HashMap<Long, Long>();
        Map<Long, Long> numbersAssert = new HashMap<Long, Long>();
        long count = 0;
        for (int x = 0; x < arr.size(); x++) {
            long element = arr.get(x);
            long nextElement = arr.get(x) * r;
            if(numbersAssert.containsKey(element)){
                count+=numbersAssert.get(element);
            }
            if (numbersPossible.containsKey(element)){
                numbersAssert.put(nextElement, numbersAssert.getOrDefault(nextElement,0L)+numbersPossible.get(element));
            }
            numbersPossible.put(nextElement, numbersPossible.getOrDefault(nextElement,0L)+1);
        }
        return count;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
