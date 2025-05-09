package com.java.coding;// Java program to find the ranges of
// consecutive numbers from array

import java.util.ArrayList;
import java.util.List;

public class FindRangesOfConsecutiveNumbers {

    // Function to find consecutive ranges
    static List<String> consecutiveRanges(int[] a){
        int length = 1;
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= a.length; i++) {
            if (i == a.length || a[i] - a[i - 1] != 1) {
                if (length == 1) {
                    list.add(String.valueOf(a[i - length]));
                }else {
                    list.add(a[i - length] + " -> " + a[i - 1]);
                }
                length = 1;
            }else {
                length++;
            }
        }
        return list;
    }

    // Driver Code.
    public static void main(String args[])
    {

        // Test Case 1:
        int[] arr1 = { 1, 2, 3, 6, 7 };
        //System.out.print(consecutiveRanges(arr1));
        System.out.println();

        // Test Case 2:
        int[] arr2 = { -1, 0, 1, 2, 5, 6, 8 };
        //System.out.print(consecutiveRanges(arr2));
        System.out.println();

        // Test Case 3:
        int[] arr3 = { -1, 3, 4, 5, 20, 21, 25 };
        //System.out.print(consecutiveRanges(arr3));

        int counter = 1;
        for(int i=1; i<= arr1.length; i++){
            if(i == arr1.length || arr1[i] - arr1[i-1] != 1){
                if(counter == 1) {
                    System.out.println(arr1[i - counter]);
                }else {
                    System.out.println(arr1[i - counter] + "-" + arr1[i - 1]);
                }

                counter = 1;
            }else{
                counter++;
            }
        }
    }


}
