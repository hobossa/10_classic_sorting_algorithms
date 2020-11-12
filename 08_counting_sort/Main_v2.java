package com.hoboss;

import java.util.Arrays;

class CountingSort {

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int n = arr.length;
        if (n > 0) {
            int min = arr[0];
            int max = arr[0];
            for (int k : arr) {
                if (k > max) {
                    max = k;
                }
                if (k < min) {
                    min = k;
                }
            }

            int number = max - min + 1;

            int[] count = new int[number];
            for (int i = 0; i < number; ++i) {
                count[i] = 0;
            }

            for (int j : arr) {
                count[j - min]++;
            }

            for (int i = 1; i < number; ++i) {
                count[i] += count[i-1];
            }


            int[] output = new int[n];
            for (int i = n-1; i >= 0; --i) {
                output[count[arr[i]-min]-1] = arr[i];
                --count[arr[i]-min];
            }

            System.arraycopy(output, 0, arr, 0, n);

        }
        return arr;
    }

}

public class Main {

    public static void main(String[] args) {
        // generate some fake data;
        int[] array = {3, 3, 6, 432, 325, 6, 2, 7, 234, 1, 432, 5, 325, 1234, 13, 41, 36, 23, 123, 32, 412, 4, 1324, 14, 2435};
        //int[] array = {7, 5, 4};
        System.out.println(Arrays.toString(CountingSort.sort(array)));
    }

}
