package com.fattoRabobank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getPasswordStrength' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING_ARRAY common_words
     */

    public static List<String> getPasswordStrength(List<String> passwords, List<String> common_words) {

       List<String> results= new ArrayList<>();
       int n=0;
        for (String password: passwords){
            boolean weak = false;
            // check passwords are numerical
            if (password.matches("^[0-9]+$")) {
                results.add(n,"weak");
                n++;
                continue;
            }
            if (password.length()<6){
                results.add(n,"weak");
                n++;
                continue;
            }
            // check passwords are lowercase
            if (password.toLowerCase(Locale.ROOT).equals(password)){
                results.add(n,"weak");
                n++;
                continue;
            }
            // check passwords are uppercase
            if (password.toUpperCase().equals(password)){
                results.add(n,"weak");
                n++;
                continue;
            }
            if (common_words.contains(password)){
                results.add(n,"weak");
                n++;
                continue;
            }
            // test substring
            boolean notCotain=true;
            for (String common_word: common_words){

                if (password.contains(common_word)){
                    results.add(n,"weak");
                    n++;
                    notCotain=false;
                    break;
                }
            }
            if (notCotain==true){
                results.add(n,"strong");
                n++;

            }



        }
        return results;
    }

}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int passwordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> passwords = IntStream.range(0, passwordsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int common_wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> common_words = IntStream.range(0, common_wordsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.getPasswordStrength(passwords, common_words);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}