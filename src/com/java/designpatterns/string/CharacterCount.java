package com.java.designpatterns.string;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CharacterCount {
    public static void main(String[] args) {
        String name = "Vijay Kumar Sharma";

        Map<Character, Long> characterCount = name.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("Character Count : "+ characterCount);

        Map<String, List<String>> countDetails1 = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity()));
        
        System.out.println(countDetails1);
        
        Map<String, Long> countDetails2 = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        System.out.println(countDetails2);

        // Find Duplicate elements in string
        List<Map.Entry<String, Long>> duplicateList = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1)
                //.map(e -> e.getKey())
                .collect(Collectors.toList());
        System.out.println(duplicateList);

        // First Non repeated element
        String firstNonRepeated = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1) // First Non repeated element
                //.filter(e -> e.getValue() > 1) // First repeated element
                .findFirst().get().getKey();

        System.out.println(firstNonRepeated);

        int[] numbers  = {2,5,3,7,9,11,15};
        int secondHighest = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(secondHighest);

        String[] chars = {"Vijay","Supriya", "Aarsh","Aradhya"};
        String maxLengthWord = Arrays.stream(chars).reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).get();
        System.out.println(maxLengthWord);

        int[] nums = {2,11,12,3,5,54};
        List<String> startsWithOne = Arrays.stream(nums).boxed().map(num -> num + "").filter(e -> e.startsWith("1")).collect(Collectors.toList());
        System.out.println(startsWithOne);

        // Use of skip and limit
        IntStream.rangeClosed(1,10)
                .skip(1)
                .limit(5)
                .forEach(System.out::println);
    }
}
