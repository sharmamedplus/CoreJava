package com.java.algorithm.sorting;

import java.util.Arrays;
//https://www.youtube.com/watch?v=v6hmmfIiKu4&list=PLlhM4lkb2sEgQ2nI2bsrKx5qIOAb7S7sc&index=1&pp=iAQB
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6,5,2,4,3};

        for(int i=0; i<arr.length-1; i++){
            for(int j = 0; j<arr.length-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
