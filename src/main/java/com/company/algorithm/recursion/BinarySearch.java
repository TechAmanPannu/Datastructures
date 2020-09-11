package com.company.algorithm.recursion;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] arr){

        /// array has to be sorted first

        int[] a = {1,5,6,8,9,10};
        int k = -1;

        searchKey(a ,k);
    }


    public static void searchKey(int[] a, int k){
        int n = a.length;
        boolean found = search(a, 0, n - 1, k);
        System.out.println("isFound : "+found);
    }

    public static boolean search(int[] a, int min, int max, int k){

        if(min > max)
            return false;

        int mid = (min + max) / 2;

        if(a[mid] == k)
            return true;
        if(k < a[mid]) {
            return search(a, min, mid - 1, k);
        }else if ( k > a[mid]){
            return search(a, mid + 1, max, k);
        }
        return false;
    }
}
