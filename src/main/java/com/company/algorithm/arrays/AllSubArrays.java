package com.company.algorithm.arrays;

public class AllSubArrays {
    public static void main(String[] arg){
    /// subarray formula : (n(n + 1))/2
        int[] a = {2,3,4};

        for(int i = 0 ;i < a.length ; i ++){
            for(int j = i; j < a.length ; j++){
                for(int k = i ; k <= j ; k++){
                    System.out.print(a[k]);
                }
                System.out.println();
            }
        }
    }
}
