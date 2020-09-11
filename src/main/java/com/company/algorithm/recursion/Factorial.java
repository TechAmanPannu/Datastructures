package com.company.algorithm.recursion;

public class Factorial {

    public static void main(String[] arr){

        System.out.println(findFactorial(4));
    }

    public static int findFactorial(int num){

        if(num == 1)
            return 1;

         return num * findFactorial(num - 1);
    }
}
