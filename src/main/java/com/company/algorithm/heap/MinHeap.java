package com.company.algorithm.heap;

/// (i ) / 2  = parent node
/// (2 * i) = left child
/// (2 * i) + 1 = right child
//// (pos >= size / 2 && pos < size) /// leaf node

public class MinHeap {
    private int[] Heap;
    private int size;
    private int maxsize;

    private static final int FRONT = 1;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }


    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {

        if (pos >= size / 2 && pos < size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {

        if(isLeaf(pos))
            return;

        if(size <= 1)
            return;

            if (Heap[pos] > Heap[leftChild(pos)]
                    || Heap[pos] > Heap[rightChild(pos)]) {


                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }


    }


    public void insert(int element) {
        if (size >= maxsize) {
            return;
        }
        Heap[++size] = element;
        int current = size;

        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void insert(int[] arr){

        for (int ele : arr) {
            insert(ele);
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

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int remove() {
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    public static void main(String arg[]) {


        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(20);
        minHeap.insert(1);
        minHeap.insert(10);
        minHeap.insert(3);
        minHeap.insert(9);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(8);
        System.out.println(minHeap.remove());
        minHeap.print();

        System.out.println(minHeap.remove());
        minHeap.print();

        System.out.println(minHeap.remove());
        minHeap.print();

        System.out.println(minHeap.remove());
        minHeap.print();

        System.out.println(minHeap.remove());
        minHeap.print();

        System.out.println(minHeap.remove());
        minHeap.print();

        System.out.println(minHeap.remove());
        minHeap.print();

        System.out.println(minHeap.remove());
        minHeap.print();

        System.out.println(minHeap.remove());
        minHeap.print();
    }
}


