package com.company.algorithm.arrays;

import java.util.Arrays;

public class ArrayInBuildJavaFunctions {

    public static void main(String[] arr){

        int[] a = {4,5,11,8,12,10};

        Arrays.sort(a);

        System.out.println("sorted in ascending order ");
        for (int element : a) {
            System.out.print(element+ " ");
        }

        System.out.println();
        System.out.println("............................");

        int[] b = {4,5,11,8,12,10};
        Arrays.sort(b, 4, 6);  /// actual index + 1

        System.out.println("partial sorting");

        for (int element : b) {
            System.out.print(element + " ");
        }

        System.out.println("................\n");
        System.out.println("isFound at index : " + Arrays.binarySearch(b, 4) + "\n");

       int[] c = Arrays.copyOfRange(b, 1, 4);

        System.out.println("copy of range ");
        for (int i : c) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("...................");

    }
}
