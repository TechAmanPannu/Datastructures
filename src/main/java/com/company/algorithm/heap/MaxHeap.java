package com.company.algorithm.heap;

public class MaxHeap {
    private int[] Heap;
    private int maxSize;
    private int size;
    private final static int FRONT = 1;

    public MaxHeap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        this.Heap = new int[maxSize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }

    public int getParent(int pos){
        return (pos / 2);
    }

    public void insert(int val){

        if(size >= maxSize )
            return;

        Heap[++size] = val;

        int current = size;

        while(Heap[current] > Heap[getParent(current)] ){
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i]
                    + " LEFT CHILD : " + Heap[2 * i]
                    + " RIGHT CHILD :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }

    public void swap(int fpos, int spos){

        int temp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = temp;
    }

    public static void main(String[] str){

        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(20);
        maxHeap.insert(1);
        maxHeap.insert(10);
        maxHeap.insert(3);
        maxHeap.insert(9);
        maxHeap.insert(6);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(8);

        maxHeap.print();
    }
}
