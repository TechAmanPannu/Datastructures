package com.company.algorithm.string;

public class Subsequence {

    public static void main(String[] arg) {
        String mainString = "abbbccccddd";
        String subString = "abcd";


        System.out.println(isSubsequence(mainString, subString));
    }

    private static boolean isSubsequence(String mainString, String subString) {

        if (subString == null || mainString == null)
            return false;

        int subStringLen = subString.length();
        int mainStringLen = mainString.length();

        if (subString.length() > mainString.length())
            return false;

        char[] subStringArr = subString.toCharArray();
        char[] mainStringArr = mainString.toCharArray();
        /// use two pointers:

        int i = 0, j = 0;

        while (i < subStringLen && j < mainStringLen) {

            if (subStringArr[i] == mainStringArr[j]) {
                i++;
                j++;
            } else
                j++;

        }
        return i == subStringLen;


    }
}
