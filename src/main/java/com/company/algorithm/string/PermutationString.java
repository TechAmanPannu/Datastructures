package com.company.algorithm.string;

import javax.print.attribute.HashDocAttributeSet;
import java.util.HashSet;
import java.util.Set;

public class PermutationString {


    /// time complexity : n * n!
    static Set<String> set = new HashSet<>();


    public static void main(String[] arg){

        String str = "ABC";

        permute(str, "");

        set.stream().forEach(element -> System.out.println(element));
    }

    private static void permute(String str, String ans) {

        if(str.length() == 0 ){
          set.add(ans);
            return;
        }

        for(int i = 0 ;i < str.length() ; i ++){

            char ch = str.charAt(i);

            String ros = str.substring(0, i) + str.substring(i + 1);
            System.out.println("i :"+i);
            System.out.println("str : "+str);
            System.out.println("ans : "+ans + ch);
            System.out.println("ros :"+ros);
            permute(ros, ans + ch);
        }
    }
}


//    static void printPermutn(String str, String ans)
//    {
//
//        // If string is empty
//        if (str.length() == 0) {
//            System.out.print(ans + " ");
//            return;
//        }
//
//        for (int i = 0; i < str.length(); i++) {
//
//            // ith character of str
//            char ch = str.charAt(i);
//
//            // Rest of the string after excluding
//            // the ith character
//            String ros = str.substring(0, i) +
//                    str.substring(i + 1);
//
//            // Recurvise call
//            printPermutn(ros, ans + ch);
//        }
//    }