package com.company.algorithm.sorting;

public class BubbleSort {

    public static void main(String[] arg){

        int[] arr = {6, 7, 1, 8, 0};

        arr =  sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] arr){

        for(int i = 0 ; i < arr.length ; i++){


            for(int j = i + 1 ; j < arr.length ; j++){


                if(arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }

            }


        }

        return arr;
    }
}
