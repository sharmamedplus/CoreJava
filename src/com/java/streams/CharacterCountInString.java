package com.java.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterCountInString {

    public static void main(String[] args) {

        Map<Character, Long> charCount = new HashMap<>();

        String name = "VijayKumar";

        charCount = name
                        .chars().mapToObj(ch -> (char) ch)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        System.out.println(charCount);

        char char_arr[] = {'A','B','B'};

        charCount = new String(char_arr)
                        .chars().mapToObj(ch -> (char)ch)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(charCount);
    }
}
