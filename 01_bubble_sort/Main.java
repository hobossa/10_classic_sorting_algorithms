package com.hoboss;


import java.util.Arrays;

class BubbleSort {
    public static int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        for (int i = 1; i < arr.length; ++i) {
            boolean switched = false;
            for (int j = 0; j < arr.length - i; ++j) {
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    switched = true;
                }
            }
            if (!switched) {
                break;
            }
        }
        return arr;
    }
}

public class Main {

    public static void main(String[] args) {
        // generate some fake data;

        int[] array = {3,5,6,2,7,234,1,432,5,325,1234,13,41,6,36,3,14,23,123,4,4,32,412,4,1324,14,};
        System.out.println(Arrays.toString(BubbleSort.sort(array)));

    }

}
