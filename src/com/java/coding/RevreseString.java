package com.java.coding;

public class RevreseString {
    public static void main(String[] args) {
        String str = "Vijay";
        char[] arr = str.toCharArray();
        for(int i=0, j = arr.length-1; i<arr.length / 2; i++, j-- ){
            char ch = arr[j];
            arr[j] = arr[i];
            arr[i] = ch;
        }
        System.out.println(new String(arr));
    }
}
