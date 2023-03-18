package com.sorting.bubblesort;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
        int numberSwaps = 0;

        boolean ordened=false;
        while (!ordened) {
            ordened=true;
            for (int x = 0; x < a.size() - 1; x++) {
                if (a.get(x) > a.get(x + 1)) {
                    ordened=false;
                    numberSwaps++;
                    int old = a.get(x + 1);
                    a.set(x + 1, a.get(x));
                    a.set(x, old);
                }
            }
        }
        //a.forEach(System.out::print);
        System.out.println("Array is sorted in " + numberSwaps + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(a.size() - 1));

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.countSwaps(a);

        bufferedReader.close();
    }
}

