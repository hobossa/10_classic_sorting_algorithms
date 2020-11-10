package com.hoboss;


import java.util.Arrays;

class SelectionSort {
    public static int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 0; i < arr.length; ++i) {
            int index_min = i;
            for (int j = i+1; j < arr.length; ++j) {
                if (arr[j] < arr[index_min]) {
                    index_min = j;
                }
            }
            if (i != index_min){
                int temp = arr[i];
                arr[i] = arr[index_min];
                arr[index_min] = temp;
            }
        }
        return arr;
    }
}

public class Main {

    public static void main(String[] args) {
        // generate some fake data;

        int[] array = {3,6,2,7,234,1,432,5,325,1234,13,41,36,23,123,32,412,4,1324,14,2435};
        System.out.println(Arrays.toString(SelectionSort.sort(array)));

    }

}
