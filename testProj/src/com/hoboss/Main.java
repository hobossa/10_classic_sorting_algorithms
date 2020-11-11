package com.hoboss;

import java.util.Arrays;

class QuickSort {

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int p = low;
        int index = low + 1;
        for (int i = index; i < high; ++i) {
            if (arr[i] < arr[p]) {
                swap(arr, index, i);
                ++index;
            }
        }
        swap(arr, --index, p);
        return index;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low + 1 < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p);
            quickSort(arr, p + 1, high);
        }
    }

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        quickSort(arr, 0, arr.length);
        return arr;
    }

}

public class Main {

    public static void main(String[] args) {
        // generate some fake data;
        int[] array = {3, 6, 2, 7, 234, 1, 432, 5, 325, 1234, 13, 41, 36, 23, 123, 32, 412, 4, 1324, 14, 2435};
        //int[] array = {7, 5, 4};
        System.out.println(Arrays.toString(QuickSort.sort(array)));
    }

}
