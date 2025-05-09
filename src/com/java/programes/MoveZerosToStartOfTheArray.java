package com.java.programes;

public class MoveZerosToStartOfTheArray {
    public static void main(String[] args) {

        moveZerosAtStart();
        System.out.println();
        moveZerosAtEnd();

    }

    private static void moveZerosAtStart() {
        System.out.println("put 0 at start");

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
    }

    private static void moveZerosAtEnd() {
        System.out.println("put 0 at end");

        int arr[] = {0,1,2,0};

        int counter = 0;

        for(int i = 0; i<= arr.length -1; i++){
            if(arr[i] != 0){
                arr[counter] = arr[i];
                counter ++;
            }
        }

        while (counter < arr.length){
            arr[counter] = 0;
            counter ++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


}
