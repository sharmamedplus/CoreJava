package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HighestOccurenceNumberInList {
    public static void main(String[] args) {
        System.out.println(args[0]);
        int arr[] = {1, 1, 2, 3, 3, 3, 2};
        Map.Entry<Integer, Long> response = Arrays.stream(arr).mapToObj(Integer::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparingLong(entry -> entry.getValue())).get();
                //.sorted((entry1, entry2) -> entry2.getValue().intValue() - entry1.getValue().intValue()).findFirst().get();

        System.out.println(response);
    }
}

