package com.company.algorithm.windowSliding;

public class MaxSumWithKNumbers {

    public static void main(String agr[]){

        int[] arr = {1, 2, 3, 4, 5};

        int max = findMax(arr, 3);
        System.out.println("Max number : "+max);
    }

    private static int findMax(int[] arr, int k) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < k ; i ++){
            sum = sum + arr[i];
        }

        if(sum > max)
            max = sum;


        for(int i = k ; i < arr.length ; i ++){
            sum = sum - arr[i - k];
            sum = sum + arr[i];

            if(sum > max)
                max = sum;

        }

        return max;

    }
}
