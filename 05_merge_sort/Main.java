package com.hoboss;

import java.util.Arrays;

class MergeSort {

    static void merge(int[] arr, int l, int m, int r) {
        int[] L = Arrays.copyOfRange(arr, l, m);
        int[] R = Arrays.copyOfRange(arr, m, r);

        int i = 0;
        int j = 0;
        int n = l;
        while (i < L.length && j < R.length) {
            if (L[i] < R[j]) {
                arr[n++] = L[i++];
            } else {
                arr[n++] = R[j++];
            }
        }

        while (i < L.length) {
            arr[n++] = L[i++];
        }
        while (j < R.length) {
            arr[n++] = R[j++];
        }
    }

    static void mergeSort(int[] arr, int l, int r) {
        if (r - l <= 1) {
        } else {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m, r);
            merge(arr, l, m, r);
        }
    }

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        mergeSort(arr, 0, arr.length);
        return arr;
    }

}

public class Main {

    public static void main(String[] args) {
        // generate some fake data;
        int[] array = {3, 6, 2, 7, 234, 1, 432, 5, 325, 1234, 13, 41, 36, 23, 123, 32, 412, 4, 1324, 14, 2435};
        //int[] array = {7, 5, 4};
        System.out.println(Arrays.toString(MergeSort.sort(array)));
    }

}
