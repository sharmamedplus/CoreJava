package com.java.algorithm.sorting;

import java.util.Arrays;

// second loop checks the minimum value and will replace with current i'th position value
// https://www.youtube.com/watch?v=GRNOoZeV6xc&list=PLlhM4lkb2sEgQ2nI2bsrKx5qIOAb7S7sc&index=2&pp=iAQB
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {3,4,2,5,1};
        int min, temp = 0;
        for(int i=0; i<arr.length; i++){
            min = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
