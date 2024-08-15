package com.java.algorithm.sorting;

import java.util.Arrays;
// https://www.youtube.com/watch?v=f-f50FjS_jA&list=PLlhM4lkb2sEgQ2nI2bsrKx5qIOAb7S7sc&index=3&pp=iAQB
public class InsertionSort {
    public static void main(String[] args) {
    int arr[] = {5,1,6,2,4,3};
    int temp, j;
    for(int i=1; i<arr.length; i++){
        temp = arr[i];
        j = i;
        while(j > 0 && arr[j-1] > temp){
            arr[j] = arr[j-1];
            j = j-1;
        }
        arr[j] = temp;
    }
        Arrays.stream(arr).forEach(System.out::print);

    }
}
