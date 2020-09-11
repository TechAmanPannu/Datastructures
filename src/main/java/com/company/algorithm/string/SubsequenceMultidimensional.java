package com.company.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceMultidimensional {

    public static void main(String[] arg){

        char[][] cha = {{'A', 'B', 'C', 'E'}, {'S','F','C', 'S'},{'A', 'D', 'E', 'E'}};

        System.out.println(exist(cha, "ABCCED"));

    }
    public static boolean exist(char[][] board, String word) {

        List<Character> boad = new ArrayList<>();

        for (char[] chars : board) {
            for (char aChar : chars) {
                boad.add(aChar);
            }
        }

        char[] wordArray = word.toCharArray();

        int i = 0,  j = 0 ;
        while(i < wordArray.length && j < boad.size() ){

            System.out.println("i valued: "+i);
            if(wordArray[i] ==  boad.get(j)){
                System.out.print(" "+wordArray[i]);
                i++;
                j++;
            }else {
                j++;
            }


        }

        System.out.println(wordArray.length);
        return i == wordArray.length;


    }
}
