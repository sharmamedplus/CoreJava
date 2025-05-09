package com.java.algorithm.searching;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {5,8,1,6,2,3};
        int[] sortedArray = Arrays.stream(arr).sorted().toArray();
        int key = 5;
        int left = 0, right = sortedArray.length-1;
        int elementIndex = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (sortedArray[mid] == key) {
                elementIndex = mid;
                break;
            }
            if(key < sortedArray[mid]){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(elementIndex);
    }
}
