package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicateFromList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(
                Arrays.asList(1, 10, 1, 2, 2, 3, 10, 3, 3, 4, 5, 5));

        System.out.println(list.stream().distinct().collect(Collectors.toList()));
        System.out.println(list.stream().distinct().sorted().collect(Collectors.toList()));
        System.out.println(list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
    }
}
