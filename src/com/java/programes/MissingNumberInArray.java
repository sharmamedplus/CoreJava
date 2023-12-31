package com.java.programes;

import java.util.Arrays;

public class MissingNumberInArray {
    public static void main(String[] args) {
        int arr[] = {1,2,4};

        int N = arr[arr.length-1];
        int sumShouldBe = (N * (N + 1)) / 2;

        int currentSum = Arrays.stream(arr).sum();

        System.out.println(sumShouldBe-currentSum);

    }
}
