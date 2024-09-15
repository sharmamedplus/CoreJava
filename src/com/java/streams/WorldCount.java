package com.java.streams;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WorldCount {
    public static void main(String[] args) {
        String str[] = {"Hello Vijay Kumar", "Vijay Sharma", "Sharma Vijay ji"};

        Long count = Arrays.stream(str).filter(s -> s.contains("Vijay"))
                .map(s -> s.split(" ")).flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getKey().equals("Vijay"))
                .findFirst().get().getValue();

        System.out.println(count);
    }
}
