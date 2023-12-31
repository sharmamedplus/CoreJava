package com.java.programes;

public class MoveZerosToStartOfTheArray {
    public static void main(String[] args) {

       // put 0 at end
        
        int[] arr = {1,0,2,0};

        int current = arr.length-1;

        for(int i = arr.length-1; i>=0; i--){

            if(arr[i] != 0){
                arr[current] = arr[i];
                current --;
            }
        }

        while (current >= 0){
            arr[current] = 0;
            current --;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // put 0 at start

        int arr2[] = {0,1,2,0};

        int start = 0;

        for(int i = 0; i<= arr2.length -1; i++){
            if(arr2[i] != 0){
                arr2[start] = arr2[i];
                start ++;
            }
        }

        while (start < arr2.length){
            arr2[start] = 0;
            start ++;
        }

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
