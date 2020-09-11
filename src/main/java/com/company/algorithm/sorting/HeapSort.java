package com.company.algorithm.sorting;

import com.company.algorithm.heap.MinHeap;

public class HeapSort {

    public static void main(String[] arg){

        int[] arr = {6, 7, 1, 8, 0};

        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(arr);

        for(int i = 0 ;i < arr.length ; i++){
            arr[i] = minHeap.remove();
        }

        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

}
