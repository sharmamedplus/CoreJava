package com.java;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

public class SortMapByValue {
    public static void main(String[] args) {

        Map<String, Integer> ageMap = new HashMap();
        ageMap.put("Vijay", 32);
        ageMap.put("Supriya", 33);
        ageMap.put("Aaradhya", 3);
        ageMap.put("Aarsh Sharma", 6);
        System.out.println(ageMap);

        Map<String, Integer> result = ageMap.entrySet().stream()
                //.sorted(Map.Entry.comparingByValue())
                //.sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey())) // By Key
                .sorted((entry1, entry2) -> entry1.getValue() - entry2.getValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2)-> e1, LinkedHashMap::new));

        System.out.println(result);

    }

}

