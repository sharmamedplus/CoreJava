package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersStartsWithOne {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 15);
        List<Integer> response = list.stream()
                .map(String::valueOf)
                .filter(num -> num.startsWith("1"))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        System.out.println(response);
    }
}
