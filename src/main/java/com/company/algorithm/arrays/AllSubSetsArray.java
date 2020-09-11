package com.company.algorithm.arrays;

import java.util.List;

public class AllSubSetsArray {

    // Print all subsets of given set[]
    static void printSubsets(String set[])
    {
        int n = set.length;
        int numberOfSubsets = 1<<n;

        for (int i = 0; i < numberOfSubsets; i++) {


            // Print current subset
            for (int j = 0; j < n; j++){


                if ((i & (1 << j)) > 0)
                    //  System.out.println("doing something : "+(1 << j));
                    System.out.print(set[j] + " ");



        }
            System.out.println("");
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        String set[] = {"orange", "apple", "apple", "banana", "orange", "banana"};
        printSubsets(set);
    }
}
