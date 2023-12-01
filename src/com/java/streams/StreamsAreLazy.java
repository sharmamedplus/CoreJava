package com.java.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAreLazy {
    public static void main(String[] args) {
        int num[] = {1,2,3,4,5};
        Stream<Integer> streamInts = Arrays.stream(num).boxed().filter(e -> {
            System.out.println("Element :" + e);
            return e >= 5;
        });

        streamInts.collect(Collectors.toList());
    }
}
