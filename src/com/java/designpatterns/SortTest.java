package com.java.designpatterns;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortTest {
    public static void main(String[] args) {

        System.out.println(Arrays.asList("1", "1F", "1f", "b", "a2", "b1", "1b").stream().sorted().collect(Collectors.toList()));

        Map<Long, String> map = new HashMap<>();
        map.put(1L, "1");
        map.put(2L, "1F");
        map.put(3L, "1f");
        map.put(4L, "b");
        map.put(5L, "a2");
        map.put(6L, "b1");
        map.put(7L, "1b");

// Sort map by Value
        LinkedHashMap<Long, String> temp =
                // First sort the entry set by its value then collect in LinkedHashMap
                map.entrySet().stream().sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                         (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(temp);
    }

}
