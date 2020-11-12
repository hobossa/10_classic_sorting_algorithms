package com.hoboss;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

class BucketSort {

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int[] sort(int[] sourceArray, int bucketCount) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int n = arr.length;
        if (n > 0) {
            // create n empty buckets
            Vector<Integer>[] buckets = new Vector[bucketCount];
            for (int i = 0; i < bucketCount; ++i) {
                buckets[i] = new Vector<Integer>();
            }

            // put into buckets
            int min = arr[0];
            int max = arr[0];
            for (int v : arr) {
                if (v < min) {
                    min = v;
                }
                if (v > max) {
                    max = v;
                }
            }
            int gap = (max - min)/ bucketCount + 1;
            for (int v : arr) {
                buckets[v / gap].add(v);
            }

            // Sort individual buckets using insertion sort.
            for (int i = 0; i < bucketCount; ++i) {
                Collections.sort(buckets[i]);
            }

            // concatenate all buckets.
            int index = 0;
            for (int i = 0; i < bucketCount; ++i) {
                for (Integer j : buckets[i]) {
                    arr[index++] = j;
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
        System.out.println(Arrays.toString(BucketSort.sort(array, 10)));
    }

}
