package com.java.coding;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContinuousSequenceOfNumbersInArray {

    public static void main(String[] args) {
        String arr[] = {"1","2","3","5","a","6","7","8","-5","-7","-3","-2","-1"};

        int new_arr[] = Arrays.stream(arr).filter(num -> {
            try{
                Integer.parseInt(num);
            }catch (Exception e){
                return  false;
            }
            return  true;
        }).mapToInt(num -> Integer.valueOf(num)).toArray();

        for(int i=0; i<new_arr.length; i++){
            StringBuilder builder = new StringBuilder("");
            for(int j = i+1; j<new_arr.length; j++){
                int next = new_arr[i] + 1;
                if(new_arr[j] == next){
                    if(builder.isEmpty()) {
                        builder.append(new_arr[i] + " " + new_arr[j]);
                    }else{
                        builder.append(" "+new_arr[j]);
                    }
                    i = j;
                }else{
                    break;
                }
            }
            System.out.println(builder);
        }
    }
}
