package com.java.coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaxNumberFormation {
    public static void main(String[] args) {
        int number = 2145;

        String res = Arrays.stream(String.valueOf(number).split(""))
                .sorted(Comparator.reverseOrder()).reduce((num1, num2) -> num1 + num2).get();
        System.out.println(Integer.parseInt(res));


        //======================================================
        String arr[] = {"2", "3", "43", "44", "5"};

        Arrays.sort(arr, (num1, num2) -> (num2+num1).compareTo(num1+num2));
        String response = "";
        for(String str : arr){
            response = response+str;
        }
        System.out.println("Max Number =" + response);
        //==========================================================

        // Get all unique combinations
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    break;
                } else {
                    System.out.println(i + " " + j);
                }
            }
        }


        List<String> resp = Arrays.asList("vijay", "sdfh").stream()
                .filter(str -> !(str.indexOf('a') >= 0 || str.indexOf('e') >= 0 || str.indexOf('i') >= 0 || str.indexOf('o') >= 0 || str.indexOf('u') >= 0))
                .collect(Collectors.toList());
        System.out.println(resp);
    }


}
