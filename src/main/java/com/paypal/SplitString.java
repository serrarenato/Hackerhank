package com.paypal;// By Renato Serra
// created: 03/16/2023

public class SplitString {

    public static String splitString(String s, Integer numberLetters) {

        // remove dashes and convert to uppercase
        String str = s.replaceAll("-", "").toUpperCase();
        int size = str.length();
        // If the size is less than numberLetters, finish the problem.
        if (size <= numberLetters) {
            return str;
        }
        int firstDash = s.indexOf('-');
        String result = "";
        // add first group

        int valueFirst = (firstDash == -1 || firstDash < numberLetters) ? firstDash: numberLetters;
        result += (str.substring(0, Math.min(valueFirst, size)));
        // for each all groups after the first
        for (int i = valueFirst; i < size; i += numberLetters) { //O(n)
            // put the first dashe
            if (result.length() > 0) {
                result += "-";
            }

            int value = i + numberLetters < size ? i + numberLetters : size;
            result += str.substring(i, value);
        }
        return result;
    }


    public static void main(String[] args) {
        String result1 = splitString("5F3Z-2e-9-w", 4);
        System.out.println(result1);
        String result2 = splitString("2-5g-3-J", 2);
        System.out.println(result2);
        String result3 = splitString("24-5g-3-J", 4);
        System.out.println(result3);

        String result4 = splitString("243-5g-3-J", 4);
        System.out.println(result4);


    /*Given a string S that consists of only alphanumeric characters and dashes.
     The string is separated into N + 1 groups by N dashes.
     Also given an integer K.
     We want to reformat the string S, such that each group contains exactly K characters,
     except for the first group, which could be shorter than K but still must contain at least one character. Furthermore,
     a dash must be inserted between two groups, and you should convert all lowercase letters to uppercase.
     */
        /*
Input: S = “5F3Z-2e-9-w”, K = 4
Output: “5F3Z-2E9W”
Explanation: The string S has been split into two parts, each part has 4 characters.
Note that two extra dashes are not needed and can be removed.
 */

/*
Input: S = “2-5g-3-J”, K = 2
Output: “2-5G-3J”
Explanation: The string s has been split into three parts,each part has 2 characters except the first part as it could be shorter as mentioned above
 */
        //diego.martinez@tallertechnologies.net

    }
}
