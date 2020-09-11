package com.company.algorithm.arrays;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String arg[]) {
        String str = "aabcca";


        removeDuplicates(str.toCharArray());
    }

//    private static String removeDups(String str) {
//
//        if (str == null || str.length() < 2)
//            return str;
//
//        int n = str.length();
//        char[] chars = str.toCharArray();
//
//        int j = 0;
//        for (int i = 1; i < n; i++) {
//
//            if (chars[j] != chars[i]) {
//
//                j++;
//                chars[j] = chars[i];
//            }
//
//        }
//
//        Arrays.copyOfRange(chars, 0, j + 1);
//
//        return String.copyValueOf(chars);
//    }

    // A iterative function that removes
    // consecutive duplicates from string S
    static void removeDuplicates(char[] S)
    {
        int n = S.length;

        // We don't need to do anything for
        // empty or single character string.
        if (n < 2)
        {
            return;
        }

        // j is used to store index is result
        // string (or index of current distinct
        // character)
        int j = 0;

        // Traversing string
        for (int i = 1; i < n; i++)
        {
            System.out.print("before : ");
            System.out.println(S);
            // If current character S[i]
            // is different from S[j]
            if (S[j] != S[i])
            {
                j++;
                System.out.println("j : "+j);
                System.out.println("i : "+i);
                S[j] = S[i];
            }
            System.out.print("after: ");
            System.out.println(S);
        }
        System.out.print("atlast : ");
        System.out.println(Arrays.copyOfRange(S, 0, j + 1));
    }
}
