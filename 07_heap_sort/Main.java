package com.hoboss;

import java.util.Arrays;

class HeapSort {

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void buildMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; --i) {
            heapify(arr, n, i);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int l = 2 * i + 1;
        int r = l + 1;
        int largest = i;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }

    }

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        buildMaxHeap(arr);
        int n = arr.length;
        for (int i = n-1; i>0; --i) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
        return arr;
    }

}

public class Main {

    public static void main(String[] args) {
        // generate some fake data;
        int[] array = {3, 6, 2, 7, 234, 1, 432, 5, 325, 1234, 13, 41, 36, 23, 123, 32, 412, 4, 1324, 14, 2435};
        //int[] array = {7, 5, 4};
        System.out.println(Arrays.toString(HeapSort.sort(array)));
    }

}
