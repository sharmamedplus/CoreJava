package com.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Sorting {

    public static void main(String[] args) {
        String s1 = "3";
        String s2 = "4";
        System.out.println(s2.compareTo(s1));

        Integer[] arr = {4, 3};
        Arrays.sort(arr, (str1,str2) -> str1 > str2 ? -1 : 1);
        System.out.println(arr[0]);
        //System.out.println(Arrays.stream(arr).sorted().toArray()[0]);
    }

}
