package com.java.designpatterns.string;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringTest {
    public static void main(String[] args) {
        int arr[] = {0,1,2,0,2,0};
        int counter = arr.length-1;

        for(int i=arr.length-1; i>0; i--){
            if(arr[i] != 0){
                arr[counter] = arr[i];
                counter --;
            }
        }
        while(counter >= 0){
            arr[counter] = 0;
            counter--;
        }

        Arrays.stream(arr).forEach(System.out::print);
    }
}
