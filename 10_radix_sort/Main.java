package com.hoboss;

import java.util.Arrays;

class RadixSort {

    // A utility function to get maximum value in arr[]
    static int getMax(int[] arr) {
        int max = arr[0];
        for (int v : arr) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        int i;
        for (i = 0; i < n; ++i) {
            ++count[(arr[i] / exp) % 10];
        }

        for (i = 1; i < 10; ++i) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; --i) {
            output[(count[(arr[i]/exp)%10]--)-1] = arr[i];
        }

        for (i = 0; i < n; ++i) {
            arr[i] = output[i];
        }
    }

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int n = arr.length;
        if (n > 0) {
            int m = getMax(arr);
            for (int exp = 1; m/exp >0; exp*=10) {
                countSort(arr, n, exp);
                // System.out.println(Arrays.toString(arr));
            }
        }
        return arr;
    }

}

public class Main {

    public static void main(String[] args) {
        // generate some fake data;
        int[] array = {3, 3, 6, 432, 325, 6, 2, 7, 234, 1, 432, 5, 325, 1234, 13, 41, 36, 23, 123, 32, 412, 4, 1324, 14, 2435};
        //int[] array = {7, 5, 4};
        System.out.println(Arrays.toString(RadixSort.sort(array)));
    }

}
