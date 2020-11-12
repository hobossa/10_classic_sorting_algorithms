package com.hoboss;

import java.util.Arrays;

class CountingSort {

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int n = arr.length;
        if (n > 0) {
            int min = arr[0];
            int max = arr[0];
            for (int i = 0; i < n; ++i) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }

            int number = max - min + 1;

            int[] count = new int[number];
            for (int i = 0; i < number; ++i) {
                count[i] = 0;
            }

            for (int i = 0; i < n; ++i) {
                count[arr[i] - min]++;
            }

            int index = 0;
            for (int i = 0; i < number; ++i) {
                int m = count[i];
                while (m-- > 0) {
                    arr[index++] = min + i;
                }
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
        System.out.println(Arrays.toString(CountingSort.sort(array)));
    }

}
