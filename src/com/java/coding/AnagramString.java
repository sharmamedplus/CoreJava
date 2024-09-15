package com.java.coding;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramString {
    public static void main(String[] args) {
        String s1 = "CAT";
        String s2 = "TAC";

        Map<Character, Long> map = s1.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        boolean is = true;
        if(s1.length() != s2.length()) {
            System.out.println("No");
        }else{
           for(Character ch : map.keySet()) {
                if(s2.indexOf(ch) == -1){
                    is = false;
                    break;
                }
            };
            System.out.println(is);
        }

    }
}
