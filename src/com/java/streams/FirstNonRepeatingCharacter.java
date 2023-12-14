package com.java.streams;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
       String name = "aabbccdeef";

        Stream<Character> s = name.chars().mapToObj(e -> (char) e); // convert to lowercase & then to Character object Stream

        Character response = s.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
                .entrySet().stream()                       // EntrySet stream
                .filter(entry -> entry.getValue() == 1L)   // extracts characters with a count of 1
                .map(entry -> entry.getKey())              // get the keys of EntrySet
                .findFirst().get();

        System.out.println(response);
    }
}
