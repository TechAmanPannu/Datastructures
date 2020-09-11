package com.company.algorithm.recursion;

public class LinearSearch {

    public static void main(String[] arr){

        int[] a = {1,5,6,8,9};
        int k = 5;

        searchKey(a ,k);
    }

    public static void searchKey(int[] a, int k){

        boolean found = search(a, a.length - 1, k);
        System.out.println("isFound : "+found);
    }

    public static boolean search(int[] a, int size, int k){

        if(size < 0)
            return false;

        if(a[size] == k)
            return true;

       return search(a, size - 1, k);

    }
}
