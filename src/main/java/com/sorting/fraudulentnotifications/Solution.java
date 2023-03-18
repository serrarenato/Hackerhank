package com.sorting.fraudulentnotifications;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static int activityNotifications(List<Integer> expenditure, int d) {
        Double median = 0d;
        int notifications = 0;
        int[] backlog = new int[201];

        // Carrega backlog
        // Os numeros vao de 0 a 200
        for (int y = d - 1; y >= 0; y--) {
            backlog[expenditure.get(y)]++;
        }
        //Collections.sort(backlog);

        for (int x = d; x < expenditure.size(); x++) {
            // Trasform to a List

            int count = 0;
            int number1 = 0, number2 = 0;
            if (d % 2 == 0) {
                for (int xx = 0; xx < 201; xx++) {
                    count += backlog[xx];
                    if (count >= d / 2 && number1==0 ) {
                        number1 = xx;
                    }
                    if (count >= d / 2 + 1 && number2==0) {
                        number2 = xx;
                        break;
                    }

                }
                median = (double) (number1 + number2) / 2;
            } else {
                for (int xx = 0; xx < 201; xx++) {
                    count += backlog[xx];
                    if (count >  d / 2) {
                        median = (double) xx;
                        break;
                    }

                }
            }

            //median = median(backlogTemp);
            //discovery if the number >= median *2 and send notification
            if (expenditure.get(x) >= median * 2) {
                notifications++;
            }
            backlog[expenditure.get(x)]++;
            backlog[expenditure.get(x - d)]--;
            //Collections.sort(backlog);

        }
        return notifications;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.activityNotifications(expenditure, d);
        System.out.print(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
