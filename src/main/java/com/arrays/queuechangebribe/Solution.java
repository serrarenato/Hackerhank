package com.arrays.queuechangebribe;

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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {

        int bribes = 0;
        for (int x = q.size() - 1; x >= 0; x--) { //O(n) - linear
            int currentNumber = q.get(x);
            if (currentNumber == x + 1)
                continue;
            if (q.get(x - 1) == x + 1) { // One number difference
                Collections.swap(q, x - 1, x);//O(1)
                bribes++;
                System.out.println(q.toString());
                continue;
            }
            if (q.get(x - 2) == x + 1) { // One number difference
                Collections.swap(q, x - 2, x - 1); //O(1) - constant
                bribes++;
                Collections.swap(q, x - 1, x);//O(1)
                bribes++;
                System.out.println(q.toString());
                continue;
            }
            System.out.println("Too Chaotic");
            return;

            // System.out.println("after "+bribes);
        }
        System.out.println(bribes);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

