package com.company.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    private static List<List<Integer>>  permutations = new ArrayList<>();
    public static void main(String[] args){

        List<Integer> arr = Arrays.asList(1,2,3);

        permute(arr, 0);

        System.out.println(permutations);

    }

    public static void permute(List<Integer> arr, int cid){

        System.out.println(arr);
        if(cid == arr.size() - 1){
           // System.out.println(arr);
          // print(arr);
           permutations.add(new ArrayList<>(arr));
           // System.out.println(permutations);
            return;
        }

        for(int i = cid ; i< arr.size() ; i++){

            swap(arr, i, cid);
            permute(arr, cid+1);
            swap(arr, i, cid);
        }

    }

    public static void swap(List<Integer> arr, int i, int j){

        int temp = arr.get(i);
        arr.set(i, arr.get(j) );
        arr.set(j, temp);
    }

    public static void print(List<Integer> arr){
        System.out.println();
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
