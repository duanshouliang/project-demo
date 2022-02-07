package com.tuen.java.leetcode;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 4, 8, 0, 5};
        heapSort2(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(i + " ");
        }
    }


    private static void headAdjust(int[] arr, int parent, int length) {
        int parentData = arr[parent];
        int child = 2 * parent + 1;
        while (child < length) {
            if (child + 1 < length && arr[child] > arr[child + 1]) {
                child++;
            }

            if (arr[parent] > arr[child]) {
                arr[parent] = arr[child];
                parent = child;
                arr[child] = parentData;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }


    public static void heapSort2(int[] arr) {
        //初始堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            headAdjust(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            headAdjust(arr, 0, i);
        }
    }


    private static void heapSort(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("null");
        }

        int length = arr.length;
        buildHeap(arr, length);
        for (int i = length - 1; i > 0; i--) {
            int tmp = arr[i];
            arr[0] = arr[i];
            arr[i] = tmp;
            length--;
            sink(arr, 0, length);
        }
    }

    private static void buildHeap(int[] arr, int length) {
        for (int i = length / 2; i >= 0; i--) {
            sink(arr, i, length);
        }
    }

    private static void sink(int arr[], int index, int length) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        int parent = index;

        if (leftChild < length && arr[leftChild] > arr[parent]) {
            parent = leftChild;
        }

        if (rightChild < length && arr[rightChild] > arr[parent]) {
            parent = rightChild;
        }

        if (parent != index) {
            int tmp = arr[index];
            arr[index] = arr[parent];
            arr[parent] = tmp;

            sink(arr, parent, length);
        }
    }
}
