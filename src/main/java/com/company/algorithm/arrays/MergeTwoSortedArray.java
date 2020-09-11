package com.company.algorithm.arrays;

public class MergeTwoSortedArray {
    public static void main(String[] arr){

        int[] a = {1,2,3};
        int n1 = a.length;
        int[] b = {6,8,9};
        int n2 = b.length;

        int[] c = new int[n1+n2];

        int i = 0, j = 0, k = 0;

        while(i < n1 && j < n2){

            if(a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[i++];

        }

        if(i < n1){
            while (i < n1){
                c[k++] = a[i++];
            }
        }

        if(j < n2){
            while (j < n2){
                c[k++] = b[j++];
            }
        }


        // printing merged array

        for(int l = 0 ; l < c.length ; l ++){
            System.out.print(c[l] );
        }

    }
}
