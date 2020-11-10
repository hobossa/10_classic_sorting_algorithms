package com.hoboss;

import java.util.Arrays;

class InsertionSort {

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; ++i) {

            int cur = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > cur) {
                arr[j+1] = arr[j];
                --j;
            }
//            while (j >= 0) {
//                if (arr[j] > cur) {
//                    arr[j+1] = arr[j];
//                } else {
//                    break;
//                }
//                --j;
//            }
            arr[j + 1] = cur;
        }
        return arr;
    }

}

public class Main {

    public static void main(String[] args) {
        // generate some fake data;
        int[] array = {3, 6, 2, 7, 234, 1, 432, 5, 325, 1234, 13, 41, 36, 23, 123, 32, 412, 4, 1324, 14, 2435};
        System.out.println(Arrays.toString(InsertionSort.sort(array)));
    }

}
