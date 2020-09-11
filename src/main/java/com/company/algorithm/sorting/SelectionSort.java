package com.company.algorithm.sorting;

public class SelectionSort {

    public static void main(String[] arg){

        int[] arr = {6, 7, 1, 8, 0};

       arr =  sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] arr){

        for(int i = 0 ; i < arr.length ; i++){

            int min = arr[i];
            int replaceIndex = i;
            for(int j = i + 1 ; j < arr.length ; j++){


                if(min > arr[j]) {
                    min = arr[j];
                    replaceIndex = j;
                }

            }

            int temp = arr[replaceIndex];
            arr[replaceIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }
}
