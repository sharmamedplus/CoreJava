package com.java.programes;

import java.util.Arrays;

public class RotateArrayElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        for(int i = 0; i< arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }

        Arrays.stream(arr).boxed().forEach(System.out::print);
    }
}
