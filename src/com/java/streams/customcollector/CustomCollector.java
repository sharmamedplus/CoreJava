package com.java.streams.customcollector;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollector {
    public static void main(String[] args) {

        Collector<Object, StringBuilder, String> joiningWithDelimiter = Collector.of(
                StringBuilder::new,
                (sb, str) -> sb.append(str).append(","),
                StringBuilder::append,
                StringBuilder::toString
        );

        String response = Arrays.asList("Vijay", "Supriya").stream().collect(joiningWithDelimiter);
        System.out.println(response);
    }
}
