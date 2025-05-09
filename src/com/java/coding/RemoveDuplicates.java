package com.java.coding;

import java.util.Arrays;

// Driver Class
public class RemoveDuplicates {
    // Function to remove duplicates from an arary
    public static int[] removeDuplicates(int[] arr) {
        Arrays.sort(arr);
        int i = 0;
        for(int j = 1; j<arr.length; j++){
            if(arr[i] != arr[j]){
                arr[++i] = arr[j];
            }
        }
        return Arrays.copyOf(arr, i + 1);
    }

    // Main Function
    public static void main(String[] args) {
        // Initialize an array
        int[] arr = {1,2,2,3,3,3,4,5,5,6,6,7};
        // Remove duplicates from the array
        int[] result = removeDuplicates(arr);
        // Print the original array
        System.out.println("Original Array: "+Arrays.toString(arr));
        // Print the updated array
        System.out.println("Array without Duplicates: " +Arrays.toString(result));
    }

}
