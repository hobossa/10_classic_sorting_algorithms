package com.hoboss;

import java.util.Arrays;

class ShellSort {

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int step = arr.length / 2; step > 0; step /= 2) {

            for (int i = step; i < arr.length; ++i) {

                int cur = arr[i];
                int j = i - step;

                while (j >= 0 && arr[j] > cur) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = cur;
            }

        }
        return arr;
    }

}

public class Main {

    public static void main(String[] args) {
        // generate some fake data;
        int[] array = {3, 6, 2, 7, 234, 1, 432, 5, 325, 1234, 13, 41, 36, 23, 123, 32, 412, 4, 1324, 14, 2435};
        System.out.println(Arrays.toString(ShellSort.sort(array)));
    }

}
