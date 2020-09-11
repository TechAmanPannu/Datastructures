package com.company.algorithm.arrays;

import sun.security.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MutlitdimensionalArray {

    public static void main(String[] arg){

        char[][] arr = new char[4][5];

        List<Character> boad = new ArrayList<>();

        for (char[] chars : arr) {
            for (char aChar : chars) {
                boad.add(aChar);
            }
        }
        boad.stream().forEach(character -> System.out.println(character));
    }
}
