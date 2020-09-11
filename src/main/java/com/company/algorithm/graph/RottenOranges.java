package com.company.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

class Element{
    int x;
    int y;
    Element(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class RottenOranges {

    static final int R = 3, C = 5;
        public static void main(String[] args)
        {
            int arr[][] = { {2, 1, 0, 2, 1},
                    {1, 0, 1, 2, 1},
                    {1, 0, 0, 2, 1}};
            int ans = rotOranges(arr);
            if(ans == -1)
                System.out.println("All oranges cannot rot");
            else
                System.out.println("Time required for all oranges to rot = " + ans);
        }

        public static int rotOranges(int[][] arr){

            int ans = 0;
            Queue<Element> queue = new LinkedList();

            for(int i = 0; i < arr.length ; i++){
                for (int j = 0 ; j < arr[i].length ; j ++){
                    if(arr[i][j] == 2) {
                        queue.add(new Element(i, j));
                    }
                }
            }

            queue.add(new Element(-1,-1));


            while(!queue.isEmpty()){

               Element element =  queue.poll();

                while(!isDelim(element)){

                        /// check with top
                        if(isValid(element.x + 1, element.y) && arr[element.x][ element.y] == 1){
        


                        }else if(isValid(element.x - 1, element.y) && arr[element.x][ element.y] == 1){ // check for down

                        }else if(isValid(element.x , element.y + 1) && arr[element.x][ element.y] == 1){ // check for right

                        }else if(isValid(element.x , element.y - 1) && arr[element.x][ element.y] == 1){ // check for left

                        }


                }

            }

            return ans;
        }

        public static boolean isValid(int i, int j){
            return i >= 0 && j >= 0 && i < R && j < C;
        }

        public static boolean isDelim(Element element){
            return (element.x == -1 && element.y == -1);
        }

}
